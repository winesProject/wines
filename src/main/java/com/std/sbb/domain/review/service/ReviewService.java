package com.std.sbb.domain.review.service;

import com.std.sbb.domain.member.entity.Member;
import com.std.sbb.domain.review.entity.Review;
import com.std.sbb.domain.review.repository.ReviewRepository;
import com.std.sbb.domain.wine.entity.Wine;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepository reviewRepository;

    public List<Review> getList(int page) {
        List<Sort.Order> sorts = new ArrayList<>();
        sorts.add(Sort.Order.desc("createDate"));
        Pageable pageable = PageRequest.of(page, 10, Sort.by(sorts));
        return this.reviewRepository.findAll();
    }

    public Review create(Wine wine, String content, Integer score, Member member) {
        Review review = Review
                .builder()
                .wine(wine)
                .content(content)
                .score(score)
                .createDate(LocalDateTime.now())
                .member(member)
                .build();
        this.reviewRepository.save(review);
        return review;
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

    public List<Review> getMyReview(String username){
        List<Review> reviewList = reviewRepository.findAll();

        ArrayList<Review> reviews = new ArrayList<>();
        for (Review r : reviewList){
            if (r.getMember().getUsername().equals(username)){
                reviews.add(r);
            }
        }
        return reviews;
    }
}
