package com.std.sbb.domain.answer.entity;

import com.std.sbb.domain.question.entity.Question;
import com.std.sbb.global.jpa.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Answer extends BaseEntity {
    @Column(columnDefinition = "TEXT")
    private String content;
    @ManyToOne
    private Question question;
}
