package com.std.sbb.domain.member.controller;

import com.std.sbb.domain.email.service.EmailService;
import com.std.sbb.domain.member.entity.Member;
import com.std.sbb.domain.member.form.*;
import com.std.sbb.domain.member.service.MemberService;
import com.std.sbb.domain.review.entity.Review;
import com.std.sbb.domain.review.service.ReviewService;
import com.std.sbb.domain.wine.entity.Wine;
import com.std.sbb.domain.wine.service.WineService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@RequiredArgsConstructor
@RequestMapping("/member")
@Controller
public class MemberController {
    private final MemberService memberService;
    private final EmailService emailService;
    private final WineService wineService;
    private final PasswordEncoder passwordEncoder;
    private final ReviewService reviewService;

    @PreAuthorize("isAnonymous()")
    @GetMapping("/login")
    public String login(LogInForm logInForm) {
        return "login_form";
    }

    @PostMapping("/userCheck")
    @ResponseBody
    public ResponseEntity<String> login(@Valid LogInForm logInForm, BindingResult bindingResult) {
        boolean isAuthenticated = memberService.getMemberByUsernameAndPassword(logInForm.getUsername(), logInForm.getPassword());

        if (!isAuthenticated) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\": true}");
        } else {
            return ResponseEntity.ok("로그인 성공!");
        }
    }

    @GetMapping("/signup")
    public String signup(Model model, MemberForm memberForm) {
        model.addAttribute("memberForm", new MemberForm());
        return "signup_form";
    }

    @PostMapping("/signup")
    public String signup(@Valid MemberForm memberForm, BindingResult bindingResult, Model model) {
        String passwordRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*\\W).{8,16}$";
        Pattern pattern = Pattern.compile(passwordRegex);
        Matcher matcher = pattern.matcher(memberForm.getPassword1());
        if (!matcher.matches()) {
            bindingResult.rejectValue("password1", "passwordPatternError", "영문 소문자, 숫자, 특수문자를 사용하세요.");
            model.addAttribute("errorMessagePatternPw", "비밀번호는 8~16자 영문 소문자, 숫자, 특수문자를 사용하세요.");
            return "signup_form";
        }
        if (!memberForm.getPassword1().equals(memberForm.getPassword2())) {
            bindingResult.rejectValue("password2", "passwordInCorrect", "비밀번호 일치하지 않습니다");
            model.addAttribute("errorMessagePw", "비밀번호가 일치하지 않습니다");
            return "signup_form";
        }
        Optional<Member> optionalMember = memberService.getMemberByEmail(memberForm.getEmail());
        if (optionalMember.isPresent()) {
            bindingResult.rejectValue("email", "emailExistError", "해당 이메일은 이미 사용중입니다");
            model.addAttribute("existEmailError", "해당 이메일은 이미 사용중입니다");
            return "signup_form";
        }
        try {
            if (memberForm.getGender().equals("true")) {
                memberForm.setGender("men");
            } else {
                memberForm.setGender("women");
            }
            this.memberService.join(
                    memberForm.getUsername(),
                    memberForm.getPassword1(),
                    memberForm.getName(),
                    memberForm.getPhoneNumber(),
                    memberForm.getEmail(),
                    memberForm.getGender(),
                    memberForm.getBirthDate(),
                    null);
        } catch (DataIntegrityViolationException e) {
            e.printStackTrace();
            bindingResult.reject("signupFailed", "이미 등록된 ID입니다.");
            model.addAttribute("errorIDMessage", "이미 사용중인 ID입니다");
            return "signup_form";
        } catch (Exception e) {
            e.printStackTrace();
            bindingResult.reject("signupFailed", e.getMessage());
            model.addAttribute("signupFail", "회원가입에 실패하였습니다");
            return "signup_form";
        }

        emailService.send(memberForm.getEmail(), "서비스 가입을 환영합니다!", "회원가입 환영 메일");
        return "redirect:/";
    }
    @PreAuthorize("isAuthenticated()")
    @GetMapping("/favorites")
    public String favorites(Model model, Principal principal) {
        Member member = this.memberService.getMember(principal.getName());
        List<Wine> paging = this.wineService.getList();
        model.addAttribute("paging", paging);
        return "member_favorites";
    }

    @GetMapping("/detail")
    @PreAuthorize("isAuthenticated()")
    public String detail(Model model, Principal principal) {
        Member member = this.memberService.getMember(principal.getName());
        model.addAttribute("member", member);
        return "member_detail";
    }

    @GetMapping("/confirm")
    public String memberConfirmPage(MemberConfirmForm memberConfirmForm) {
        return "member_confirm";
    }

    @PostMapping("/confirm")
    public String memberConfirm(@Valid MemberConfirmForm memberConfirmForm, BindingResult bindingResult, Principal principal) {
        if (bindingResult.hasErrors()) {
            return "member_confirm";
        }
        Member member = this.memberService.getMember(principal.getName());
        if (!memberConfirmForm.getUsername().equals(member.getUsername())) {
            bindingResult.rejectValue("username", "usernameInCorrect",
                    "유저이름이 일치하지 않습니다.");
            return "member_confirm";
        }
        return "redirect:/member/detail";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/detail/modifyPw")
    public String modifyPassword(MemberPwForm memberPwForm) {
        return "modify_pw";
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/detail/modifyPw")
    public String modifyPassword(@Valid MemberPwForm memberPwForm, BindingResult bindingResult, Principal principal, Model model) {
        Member member = this.memberService.getMember(principal.getName());
        if (bindingResult.hasErrors()) {
            return "modify_pw";
        }
        if (!passwordEncoder.matches(memberPwForm.getPassword(), member.getPassword())) {
            bindingResult.rejectValue("password", "passwordNotMatch", "기존 비밀번호가 일치하지 않습니다.");
            model.addAttribute("passwordNotMatchError", "기존 비밀번호가 일치하지 않습니다.");
            return "modify_pw";
        }
        String passwordRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*\\W).{8,16}$";
        Pattern pattern = Pattern.compile(passwordRegex);
        Matcher matcher = pattern.matcher(memberPwForm.getNewPassword());
        if (!matcher.matches()) {
            bindingResult.rejectValue("newPassword", "passwordPatternError", "영문 소문자, 숫자, 특수문자를 사용하세요.");
            model.addAttribute("errorMessagePatternPw", "비밀번호는 8~16자 영문 소문자, 숫자, 특수문자를 사용하세요.");
            return "modify_pw";
        }
        if (!memberPwForm.getNewPassword().equals(memberPwForm.getPasswordConfirm())) {
            bindingResult.rejectValue("passwordConfirm", "passwordInCorrect", "비밀번호 일치하지 않습니다");
            model.addAttribute("errorMessagePw", "비밀번호가 일치하지 않습니다");
            return "modify_pw";
        }
        this.memberService.modifyPw(member, memberPwForm.getPasswordConfirm());

        return "redirect:/member/detail";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/detail/modifyDetail")
    public String modifyDetail(HttpServletRequest request, MemberDetailForm memberDetailForm, Model model, Principal principal) {
        HttpSession session = request.getSession();
        Member modifiedMember = (Member) session.getAttribute("modifiedMember");
        if (modifiedMember != null) {
            Member modifymember = this.memberService.getMember(modifiedMember.getUsername());
            memberDetailForm.setName(modifymember.getName());
            memberDetailForm.setEmail(modifymember.getEmail());
            memberDetailForm.setPhoneNumber(modifymember.getPhoneNumber());
        } else {
            Member member = this.memberService.getMember(principal.getName());
            memberDetailForm.setName(member.getName());
            memberDetailForm.setEmail(member.getEmail());
            memberDetailForm.setPhoneNumber(member.getPhoneNumber());
        }
        return "member_modify";
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/detail/modifyDetail")
    public String modifyDetail(HttpServletRequest request, @Valid MemberDetailForm memberDetailForm, BindingResult bindingResult, Model model, Principal principal) {
        try {
            Member member = this.memberService.getMember(principal.getName());
            if (bindingResult.hasErrors()) {
                return "member_modify";
            }
            Member modifiedMember = this.memberService.modify(member, memberDetailForm.getName(), memberDetailForm.getPhoneNumber(), memberDetailForm.getEmail());
            HttpSession session = request.getSession();
            session.setAttribute("modifiedMember", modifiedMember);
        } catch (RuntimeException e) {
            return "member_modify";
        }
        return "redirect:/member/detail";
    }

    @GetMapping("/search")
    public String findusername(IdSearchForm idSearchForm) {
        return "idSearch_form";
    }

    @PostMapping("/search")
    @ResponseBody
    public ResponseEntity<String> getUsername(@Valid IdSearchForm idSearchForm) {
        String username = memberService.getUsernameByNameAndEmail(idSearchForm.getName(), idSearchForm.getEmail());
        return ResponseEntity.ok(username);
    }

    @GetMapping("/passwordSearch")
    public String findPassword(MemberForm memberForm) {
        return "passwordSearch_form";
    }

    @PostMapping("/passwordSearch")
    @ResponseBody
    public ResponseEntity<String> findPassword(@Valid MemberForm memberForm, BindingResult bindingResult) {
        boolean isEmailValid = memberService.memberEmailCheck(memberForm.getUsername(), memberForm.getEmail());

        if (isEmailValid) {
            emailService.createMailAndChangePassword(memberForm.getEmail());
            return ResponseEntity.ok("임시 비밀번호를 발급하였습니다.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("일치하는 계정이 없습니다.");
        }
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/review")
    public String answer(Model model, Principal principal) {
        List<Review> myReviewList = reviewService.getMyReview(principal.getName());

        model.addAttribute("myReviewList", myReviewList);
        return "member_review";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/quit")
    public String quit(LogInForm logInForm, Model model, Principal principal) {
        Member member = this.memberService.getMember(principal.getName());
        model.addAttribute("member", member);
        return "member_quit";
    }
    @PostMapping("/quitUser")
    @ResponseBody
    public ResponseEntity<String> quitUser(Principal principal) {
        Member member = this.memberService.getMember(principal.getName());
        if (member != null) {
            this.memberService.deleteMemberWineByMemberId(member.getId());
            this.memberService.quit(member);
            return ResponseEntity.ok("회원탈퇴가 완료되었습니다");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\": true}");
        }
    }
    @GetMapping("/tos")
    public String termsOfService() {
        return "terms_of_service";
    }
}