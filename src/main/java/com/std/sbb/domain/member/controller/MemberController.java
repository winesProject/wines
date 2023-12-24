package com.std.sbb.domain.member.controller;

import com.std.sbb.domain.email.service.EmailService;
import com.std.sbb.domain.member.form.MemberForm;
import com.std.sbb.domain.member.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@RequestMapping("/member")
@Controller
public class MemberController {
    private final MemberService memberService;
    private final EmailService emailService;
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
    public String detail() {
        return "member_detail";
    }

}