package com.std.sbb.domain.question.form;

import com.std.sbb.global.jpa.BaseEntity;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Getter
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class QuestionForm extends BaseEntity {
    @NotNull(message = "제목은 필수항목입니다.")
    private String article;

    @NotNull(message = "내용은 필수항목입니다.")
    private String content;
}
