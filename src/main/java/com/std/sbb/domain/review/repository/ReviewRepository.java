package com.std.sbb.domain.review.repository;

import com.std.sbb.domain.member.entity.Member;
import com.std.sbb.domain.review.entity.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    Page<Review> findAll(Specification<Review> spec, Pageable pageable);

    List<Review> findByUsername(Member member);
}
