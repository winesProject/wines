package com.std.sbb.domain.review.form;

import com.std.sbb.global.jpa.BaseEntity;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ReviewForm extends BaseEntity {
    @NotNull(message = "내용은 필수항목입니다.")
    private String content;

    @NotNull(message = "평점은 필수항목입니다.")
    private Integer score;
}
