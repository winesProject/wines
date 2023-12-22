package com.std.sbb.domain.review.entity;

import com.std.sbb.domain.like.entity.Like;
import com.std.sbb.domain.member.entity.Member;
import com.std.sbb.domain.wine.entity.Wine;
import com.std.sbb.global.jpa.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@Getter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Review extends BaseEntity {
    private String username;
    @Column(length = 200)
    private String subject;
    @Column(columnDefinition = "TEXT")
    private String content;
    private Integer score;
    @ManyToOne
    private Member member;
    @ManyToOne
    private Wine wine;
    @OneToMany(mappedBy = "review", cascade = CascadeType.REMOVE)
    private List<Like> like;
}
