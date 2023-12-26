package com.std.sbb.domain.review.service;

import com.std.sbb.domain.member.entity.Member;
import com.std.sbb.domain.review.entity.Review;
import com.std.sbb.domain.review.repository.ReviewRepository;
import com.std.sbb.domain.wine.entity.Wine;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepository reviewRepository;

    public List<Review> getList() {
       return this.reviewRepository.findAll();
    }

    public void create(Wine wine, String content, Integer score, Member member) {
        Review review = Review
                .builder()
                .wine(wine)
                .content(content)
                .score(score)
                .member(member)
                .createDate(LocalDateTime.now())
                .build();
    }
}
