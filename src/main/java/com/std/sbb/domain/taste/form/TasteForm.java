package com.std.sbb.domain.taste.form;

import com.std.sbb.global.jpa.BaseEntity;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class TasteForm extends BaseEntity {
    @NotEmpty(message = "필수")
    private Integer sweet;
    @NotEmpty(message = "필수")
    private Integer body;
    @NotEmpty(message = "필수")
    private Integer acidity;
    @NotEmpty(message = "필수")
    private Integer tannin;
}
