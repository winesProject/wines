package com.std.sbb.domain.member.controller;

import com.std.sbb.domain.email.service.EmailService;
import com.std.sbb.domain.member.form.MemberForm;
import com.std.sbb.domain.member.service.MemberService;
import com.std.sbb.domain.wine.entity.Wine;
import com.std.sbb.domain.wine.service.WineService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.Map;


@RequiredArgsConstructor
@RequestMapping("/member")
@Controller
public class MemberController {
    private final MemberService memberService;
    private final EmailService emailService;
    private final WineService wineService;

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

    @GetMapping("/detail")
    public String favorites(Model model) {
        List<Wine> paging = this.wineService.getList();
        paging.sort(Comparator.comparing(Wine::getCreateDate).reversed());
        model.addAttribute("paging", paging);
        return "member_detail";
    }

    @GetMapping("/search")
    public String findusername(MemberForm memberForm){
        return "idSearch_form";
    }

    @PostMapping("/search")
    @ResponseBody
    public ResponseEntity<String> getUsername(@Valid MemberForm memberForm) {
        String username = memberService.getUsernameByNameAndEmail(memberForm.getName(), memberForm.getEmail());
        return ResponseEntity.ok(username);
    }

    @GetMapping("/passwordSearch")
    public String findPassword(){
        return "passwordSearch_form";
    }

    @PostMapping("/passwordSearch")
    @ResponseBody
    public ResponseEntity<String> findPassword(@RequestBody Map<String, String> requestData) {
        String email = requestData.get("email");
        try {
            emailService.createMailAndChangePassword(email);

            return ResponseEntity.ok("임시 비밀번호를 발급하였습니다.");
        } catch (UsernameNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("일치하는 계정이 없습니다.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("서버 오류");
        }
    }
}