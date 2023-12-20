package com.std.sbb.domain.member.controller;

import com.std.sbb.domain.member.form.MemberForm;
import com.std.sbb.domain.member.service.MemberService;
import com.std.sbb.global.email.entity.MailVo;
import com.std.sbb.global.email.service.MailService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequiredArgsConstructor
@RequestMapping("/member")
@Controller
public class MemeberController {
    private final MailService mailService;
    private final MemberService memberService;
    /** 이메일이 DB에 존재하는지 확인 **/
    @GetMapping("/checkEmail")
    public boolean checkEmail(@RequestParam("memberEmail") String memberEmail){

        return memberService.checkEmail(memberEmail);
    }
    @PostMapping("/sendPwd")
    public String sendPwdEmail(@RequestParam("memberEmail") String memberEmail) {

        /** 임시 비밀번호 생성 **/
        String tmpPassword = memberService.getTmpPassword();

        /** 임시 비밀번호 저장 **/
        memberService.updatePassword(tmpPassword, memberEmail);

        /** 메일 생성 & 전송 **/
        MailVo mail = mailService.createMail(tmpPassword, memberEmail);
        mailService.sendMail(mail);

        return "login_form";
    }
    @GetMapping("/login")
    public String login(){
        return "login_form";
    }
    @GetMapping("/signup")
    public String signup(Model model) {
        model.addAttribute("memberForm", new MemberForm());
        return "signup_form";
    }
    @PostMapping("/signup")
    public String signup(@Valid MemberForm memberForm, BindingResult bindingResult){
        if (!memberForm.getPassword1().equals(memberForm.getPassword2())){
            throw new RuntimeException("비밀번호가 일치하지 않습니다.");
        }
        this.memberService.join(
                memberForm.getNickname(),
                memberForm.getPassword1(),
                memberForm.getUsername(),
                memberForm.getPhoneNumber(),
                memberForm.getEmail(),
                Boolean.valueOf(memberForm.getGender()),
                memberForm.getBirthDate(),
                null
        );
        return "redirect:/";
    }
    @GetMapping("/detail")
    public String detail(){
        return "member_detail";
    }
}