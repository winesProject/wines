package com.std.sbb.domain.question.entity;

import com.std.sbb.domain.answer.entity.Answer;
import com.std.sbb.domain.member.entity.Member;
import com.std.sbb.domain.questionArticle.entity.QuestionArticle;
import com.std.sbb.global.jpa.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@Getter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Question extends BaseEntity {
    private String username;
    @Column(length = 200)
    private String article;
    @Column(columnDefinition = "TEXT")
    private String content;
    @OneToOne(mappedBy = "question")
    private QuestionArticle questionArticle;
    @OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE)
    private List<Answer> answer;
    @ManyToOne
    private Member member;
}
