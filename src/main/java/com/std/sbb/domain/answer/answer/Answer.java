package com.std.sbb.domain.answer.answer;

import com.std.sbb.domain.question.entity.Question;
import com.std.sbb.global.jpa.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Answer extends BaseEntity {
    @Column(columnDefinition = "TEXT")
    private String content;
    @OneToOne(mappedBy = "answer", cascade = CascadeType.REMOVE)
    private Question question;
}
