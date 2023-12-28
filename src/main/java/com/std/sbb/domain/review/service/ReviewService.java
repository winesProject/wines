package com.std.sbb.domain.review.service;

import com.std.sbb.domain.member.entity.Member;
import com.std.sbb.domain.review.entity.Review;
import com.std.sbb.domain.review.repository.ReviewRepository;
import com.std.sbb.domain.wine.entity.Wine;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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
                .createDate(LocalDateTime.now())
                .member(member)
                .build();
        this.reviewRepository.save(review);
    }

    public Review getReview(Long id) {
        Optional<Review> review = this.reviewRepository.findById(id);
        return review.get();
    }

    public void like(Review review, Member member) {
        review.getLike().add(member);
        this.reviewRepository.save(review);
    }

    public void delete(Review review) {
        this.reviewRepository.delete(review);
    }
}
