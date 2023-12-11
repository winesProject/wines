package com.std.sbb.member.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@RequestMapping("/member")
@Controller
public class MemeberController {

    @GetMapping("/login")
    public String login(){
        return "login_form";
    }
    @GetMapping("/signup")
    public String signup() {
        return "signup_form";
    }
}
