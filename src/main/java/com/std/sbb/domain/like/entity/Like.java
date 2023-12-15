package com.std.sbb.domain.like.entity;

import com.std.sbb.domain.member.entity.Member;
import com.std.sbb.domain.review.entity.Review;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Review review;
    @ManyToOne
    private Member member;
}
