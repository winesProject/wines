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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/review")
public class ReviewController {
    private final ReviewService reviewService;
    private final WineService wineService;
    private final MemberService memberService;

    @GetMapping("/list")
    public String list(Model model, @RequestParam(value = "page", defaultValue = "0") int page) {
        List<Review> paging = this.reviewService.getList(page);
        model.addAttribute("paging", paging);
        return "wineArticle_detail";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/create/{id}")
    public String create(Model model, @PathVariable("id") long id) {
        Wine wine = this.wineService.getWine(id);
        model.addAttribute("wine", wine);
        return "wineArticle_detail";
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/create/{id}")
    public String create(@Valid ReviewForm reviewForm, BindingResult bindingResult,
                         @PathVariable("id") Long id, Principal principal) {
//    if (bindingResult.hasErrors()) {
//        return String.format("redirect:/article/detail/%s", id);
//    }
        Wine wine = this.wineService.getWine(id);
        Member member = this.memberService.getMember(principal.getName());
        this.reviewService.create(wine, reviewForm.getContent(), reviewForm.getScore(), member);
        return String.format("redirect:/article/detail/%s#review_%s", id, reviewForm.getId());
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/like/{id}")
    @ResponseBody
    public ResponseEntity<String> like(Principal principal, @PathVariable("id") Long id) {
        Review review = this.reviewService.getReview(id);
        Member member = this.memberService.getMember(principal.getName());
        this.reviewService.like(review, member);

        return ResponseEntity.ok("success");
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/delete/{id}")
    public String delete(Principal principal, @PathVariable("id") Long id) {
        Review review = this.reviewService.getReview(id);
        if (!review.getMember().getUsername().equals(principal.getName())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "삭제권한이 없습니다.");
        }
        this.reviewService.delete(review);
        return String.format("redirect:/article/detail/%s", review.getWine().getId());
    }
}
