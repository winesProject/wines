package com.std.sbb.domain.answer.controller;

import com.std.sbb.domain.answer.service.AnswerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class AnswerController {
    private final AnswerService answerService;


}
