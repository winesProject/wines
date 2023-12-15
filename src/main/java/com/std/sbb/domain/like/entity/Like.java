package com.std.sbb.domain.like.entity;

import com.std.sbb.domain.member.entity.Member;
import com.std.sbb.domain.review.entity.Review;
import com.std.sbb.global.jpa.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

@Entity
@Getter
@Data
public class Like extends BaseEntity {

    @ManyToOne
    private Review review;
    @ManyToOne
    private Member member;
}
