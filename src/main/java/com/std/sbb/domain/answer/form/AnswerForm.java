package com.std.sbb.domain.answer.form;

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
public class AnswerForm extends BaseEntity {
    @NotNull(message = "내용은 필수입니다.")
    private String content;
}
