package com.std.sbb.domain.questionArticle.entity;

import com.std.sbb.domain.member.entity.Member;
import com.std.sbb.domain.question.entity.Question;
import com.std.sbb.global.jpa.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class QuestionArticle extends BaseEntity {
    @Column(length = 200)
    private String article;
    @Column(columnDefinition = "TEXT")
    private String content;
    @ManyToOne
    private Member member;
    @OneToOne
    private Question question;
}
