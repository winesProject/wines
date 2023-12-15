package com.std.sbb.domain.questionArticle.entity;

import com.std.sbb.domain.member.entity.Member;
import com.std.sbb.domain.question.entity.Question;
import com.std.sbb.global.jpa.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class QuestionArticle extends BaseEntity {
    @Column(length = 200)
    private String article;
    @Column(columnDefinition = "TEXT")
    private String content;
    @OneToMany
    private Member member;
    @OneToOne
    private Question question;
}
