package com.std.sbb.domain.answer.entity;

import com.std.sbb.domain.question.entity.Question;
import com.std.sbb.global.jpa.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.Getter;

@Entity
@Getter
@Data
public class Answer extends BaseEntity {
    @Column(columnDefinition = "TEXT")
    private String content;
    @ManyToOne
    private Question question;
}
