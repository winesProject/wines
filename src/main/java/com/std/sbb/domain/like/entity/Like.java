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
    @OneToMany(mappedBy = "like", cascade = CascadeType.REMOVE)
    private Review review;
    @OneToMany(mappedBy = "like", cascade = CascadeType.REMOVE)
    private Member member;
}
