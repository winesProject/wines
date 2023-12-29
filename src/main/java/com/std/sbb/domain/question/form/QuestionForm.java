package com.std.sbb.domain.question.form;

import com.std.sbb.global.jpa.BaseEntity;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuestionForm extends BaseEntity {
    @NotNull(message = "제목은 필수항목입니다.")
    private String article;

    @NotNull(message = "내용은 필수항목입니다.")
    private String content;
}
