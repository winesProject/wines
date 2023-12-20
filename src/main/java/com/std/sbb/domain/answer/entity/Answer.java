package com.std.sbb.domain.answer.entity;

import com.std.sbb.domain.question.entity.Question;
import com.std.sbb.global.jpa.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Answer extends BaseEntity {
    @Column(columnDefinition = "TEXT")
    private String content;

    @ManyToOne
    private Question question;
}
