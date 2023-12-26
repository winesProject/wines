package com.std.sbb.domain.email.controller;


import com.std.sbb.domain.email.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class EmailController {

    private final EmailService emailService;

    @ResponseBody
    @RequestMapping("/email")
    public String emailSend(@RequestParam("email") String email){
        int number = emailService.sendEmail(email);

        String num = "" + number;

        return num;
    }

}
