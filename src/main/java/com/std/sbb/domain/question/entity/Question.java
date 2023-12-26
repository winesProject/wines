package com.std.sbb.domain.question.entity;

import com.std.sbb.domain.answer.entity.Answer;
import com.std.sbb.domain.member.entity.Member;
import com.std.sbb.global.jpa.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@Getter
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Question extends BaseEntity {
    private String username;

    @Column(length = 200)
    private String article;

    @Column(columnDefinition = "TEXT")
    private String content;

    @OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE)
    private List<Answer> answerList;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;
}
