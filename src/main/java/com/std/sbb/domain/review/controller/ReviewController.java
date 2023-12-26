package com.std.sbb.domain.review.controller;

import com.std.sbb.domain.member.entity.Member;
import com.std.sbb.domain.member.service.MemberService;
import com.std.sbb.domain.review.entity.Review;
import com.std.sbb.domain.review.form.ReviewForm;
import com.std.sbb.domain.review.service.ReviewService;
import com.std.sbb.domain.wine.entity.Wine;
import com.std.sbb.domain.wine.service.WineService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
@RequestMapping("/review")
public class ReviewController {
    private final ReviewService reviewService;
    private final WineService wineService;
    private final MemberService memberService;

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/create/{id}")
    public String list(Model model, @PathVariable("id") long id) {
        Wine wine = this.wineService.getWine(id);
        model.addAttribute("wine", wine);

        return "wineArticle_detail";
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/create/{id}")
    public String create(@Valid ReviewForm reviewForm, BindingResult bindingResult,
                         @PathVariable("id") Long id) {
//    if (bindingResult.hasErrors()) {
//        return String.format("redirect:/article/detail/%s", id);
//    }
        Wine wine = this.wineService.getWine(id);

        this.reviewService.create(wine, reviewForm.getContent(), reviewForm.getScore());
        return String.format("redirect:/article/detail/%s", id);
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/like/{id}")
    public String like(Principal principal, @PathVariable("id") Long id) {
        Review review = this.reviewService.getReview(id);
        Member member = this.memberService.getMember(principal.getName());
        this.reviewService.like(review, member);
        return String.format("redirect:/article/detail/%s", review.getWine().getId());
    }
}
