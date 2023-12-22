package com.std.sbb.domain.review.controller;

import com.std.sbb.domain.review.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/review")
public class ReviewController {
    private final ReviewService reviewService;

//    @GetMapping("/list")
//    public String list(Model model, Am) {
//        this.reviewService.getList();
//    }
}
