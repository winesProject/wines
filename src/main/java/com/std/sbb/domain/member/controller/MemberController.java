package com.std.sbb.domain.member.controller;

import com.std.sbb.domain.email.service.EmailService;
import com.std.sbb.domain.member.entity.Member;
import com.std.sbb.domain.member.form.MemberForm;
import com.std.sbb.domain.member.service.MemberService;
import com.std.sbb.domain.wine.entity.Wine;
import com.std.sbb.domain.wine.service.WineService;
import com.std.sbb.global.security.UserSecurityService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Comparator;
import java.util.List;


@RequiredArgsConstructor
@RequestMapping("/member")
@Controller
public class MemberController {
    private final MemberService memberService;
    private final EmailService emailService;
    private final WineService wineService;
    private UserSecurityService userSecurityService;

    @PreAuthorize("isAnonymous()")
    @GetMapping("/login")
    public String login() {
        return "login_form";
    }

    @GetMapping("/signup")
    public String signup(Model model, MemberForm memberForm) {
        model.addAttribute("memberForm", new MemberForm());
        return "signup_form";
    }

    @PostMapping("/signup")
    public String signup(@Valid MemberForm memberForm, BindingResult bindingResult) {
        if (!memberForm.getPassword1().equals(memberForm.getPassword2())) {
            throw new RuntimeException("비밀번호가 일치하지 않습니다.");
        }

        try {
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
            bindingResult.reject("signupFailed", "이미 등록된 사용자입니다.");
            return "signup_form";
        } catch (Exception e) {
            e.printStackTrace();
            bindingResult.reject("signupFailed", e.getMessage());
            return "signup_form";
        }

        emailService.send(memberForm.getEmail(), "서비스 가입을 환영합니다!", "회원가입 환영 메일");
        return "redirect:/";
    }
    @PreAuthorize("isAuthenticated()")
    @GetMapping("/favorites")
    public String favorites(Model model) {
        List<Wine> paging = this.wineService.getList();
        paging.sort(Comparator.comparing(Wine::getCreateDate).reversed());
        model.addAttribute("paging", paging);
        return "member_favorites";
    }
    @PreAuthorize("isAuthenticated()")
    @GetMapping("/detail")
    public String modify(HttpServletRequest request, MemberForm memberForm, Model model, Principal principal) {
        HttpSession session = request.getSession();
        Member modifiedMember = (Member) session.getAttribute("modifiedMember");
        if (modifiedMember != null) {
            Member modifymember = this.memberService.getMember(modifiedMember.getUsername());
            memberForm.setUsername(modifymember.getUsername());
            memberForm.setName(modifymember.getName());
            memberForm.setEmail(modifymember.getEmail());
            memberForm.setPhoneNumber(modifymember.getPhoneNumber());
        } else {
            Member member = this.memberService.getMember(principal.getName());
            memberForm.setUsername(member.getUsername());
            memberForm.setName(member.getName());
            memberForm.setEmail(member.getEmail());
            memberForm.setPhoneNumber(member.getPhoneNumber());
        }
        return "member_detail";
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/detail")
    public String modify(HttpServletRequest request, @Valid MemberForm memberForm, BindingResult bindingResult, Model model, Principal principal) {
        try {
            Member member = this.memberService.getMember(principal.getName());
            if (bindingResult.hasErrors()) {
                return "member_detail";
            }
            if (!memberForm.getPassword1().equals(memberForm.getPassword2())) {
                bindingResult.rejectValue("repeat-password", "passwordInCorrect",
                        "2개의 패스워드가 일치하지 않습니다.");
                model.addAttribute("passwordError", "2개의 패스워드가 일치하지 않습니다.");
                return "member_detail";
            }
            Member modifiedMember = this.memberService.modify(member, memberForm.getUsername(),
                    memberForm.getPassword1(), memberForm.getName(), memberForm.getPhoneNumber(), memberForm.getEmail());
            HttpSession session = request.getSession();
            session.setAttribute("modifiedMember", modifiedMember);
        } catch (RuntimeException e) {
            return "member_detail";
        }
        return "redirect:/member/detail";
    }
    @PreAuthorize("isAuthenticated()")
    @GetMapping("/answer")
    public String answer() {
        return "member_answer";
    }



    @GetMapping("/search")
    public String findusername(MemberForm memberForm) {
        return "idSearch_form";
    }

    @PostMapping("/search")
    @ResponseBody
    public ResponseEntity<String> getUsername(@Valid MemberForm memberForm) {
        String username = memberService.getUsernameByNameAndEmail(memberForm.getName(), memberForm.getEmail());
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

}