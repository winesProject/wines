package com.std.sbb.domain.review.controller;

import com.std.sbb.domain.member.service.MemberService;
import com.std.sbb.domain.review.entity.Review;
import com.std.sbb.domain.review.service.ReviewService;
import com.std.sbb.domain.wine.service.WineService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/review")
public class ReviewController {
    private final ReviewService reviewService;
    private final WineService wineService;
    private final MemberService memberService;

    @GetMapping("/list")
    public String list(Model model) {
        List<Review> reviewList = this.reviewService.getList();
        model.addAttribute("reviewList", reviewList);
        return "wineArticle_detail";
    }

//    @PostMapping("/create{id}")
//    public String create(@Valid ReviewForm reviewForm, BindingResult bindingResult,
//                         @PathVariable("id") Long id, Principal principal) {
//      Wine wine = this.wineService.getWine(id);
//      Member member = this.memberService.getMember(principal.getName());
//      this.reviewService.create(wine, reviewForm.getContent(), reviewForm.getScore(), member);
//    }
}
