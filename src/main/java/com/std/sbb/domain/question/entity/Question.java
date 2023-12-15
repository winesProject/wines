package com.std.sbb.domain.question.entity;

import com.std.sbb.domain.answer.answer.Answer;
import com.std.sbb.domain.questionArticle.entity.QuestionArticle;
import com.std.sbb.global.jpa.BaseEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Question extends BaseEntity {
    private String username;
    @Column(length = 200)
    private String article;
    @Column(columnDefinition = "TEXT")
    private String content;
    @OneToOne(mappedBy = "question", cascade = CascadeType.REMOVE)
    private QuestionArticle questionArticle;
    @OneToOne
    private Answer answer;
}
