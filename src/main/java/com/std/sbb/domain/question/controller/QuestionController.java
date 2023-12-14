package com.std.sbb.domain.question.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/question")
@RequiredArgsConstructor
public class QuestionController {

    @GetMapping("/list")
    public String list(){
        return "question_list";
    }

    @GetMapping("/create")
    public String questionCreate(){
        return "question_form";
    }
}
