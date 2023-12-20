package com.std.sbb.domain.question.controller;

import com.std.sbb.domain.question.entity.Question;
import com.std.sbb.domain.question.form.QuestionForm;
import com.std.sbb.domain.question.service.QuestionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/question")
public class QuestionController {
    private final QuestionService questionservice;

    @GetMapping("/list")
    public String list(Model model) {
        List<Question> questionList = this.questionservice.getList();
        model.addAttribute("questionList", questionList);
        return "question_list";
    }

    @GetMapping("/detail/{id}")
    public String detail(Model model, @PathVariable("id") Long id) {
        Question question = this.questionservice.getId(id);
        model.addAttribute("question",question);
        return "question_detail";
    }
    @GetMapping("/create")
    public String questionCreate (QuestionForm questionForm) {
        return "question_form";
    }

    @PostMapping("/create")
    public String questionCreate(@Valid QuestionForm questionForm, BindingResult bindingResult
                                ) {
        this.questionservice.create(questionForm.getArticle(),questionForm.getContent());
        return "redirect:/question/list";
    }
}
