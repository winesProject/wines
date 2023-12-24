package com.std.sbb.domain.question.controller;

import com.std.sbb.domain.answer.form.AnswerForm;
import com.std.sbb.domain.member.entity.Member;
import com.std.sbb.domain.member.service.MemberService;
import com.std.sbb.domain.question.entity.Question;
import com.std.sbb.domain.question.form.QuestionForm;
import com.std.sbb.domain.question.service.QuestionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
@RequestMapping("/question")
public class QuestionController {
    private final QuestionService questionservice;
    private final MemberService memberService;

    @GetMapping("/list")
    public String list(Model model, @RequestParam(value="page", defaultValue="0") int page, @RequestParam(value = "kw", defaultValue = "") String kw) {
        Page<Question> paging = this.questionservice.getList(page, kw);
        model.addAttribute("paging", paging);
        return "question_list";
    }

    @GetMapping("/detail/{id}")
    public String detail(Model model, @PathVariable("id") Long id, AnswerForm answerForm) {
        Question question = this.questionservice.getId(id);
        model.addAttribute("question",question);
        return "question_detail";
    }
    @PreAuthorize("isAuthenticated()")
    @GetMapping("/create")
    public String questionCreate (QuestionForm questionForm) {
        return "question_form";
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/create")
    public String questionCreate(@Valid QuestionForm questionForm, BindingResult bindingResult,
                                 Principal principal) {
        if(bindingResult.hasErrors()) {
            return "question_form";
        }
        Member member = this.memberService.getMember(principal.getName());
        this.questionservice.create(questionForm.getArticle(),questionForm.getContent(), member);
        return "redirect:/question/list";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id, Principal principal) {
        Question question = this.questionservice.getId(id);
        this.questionservice.delete(question);
        return "redirect:/question/list";
    }
}
