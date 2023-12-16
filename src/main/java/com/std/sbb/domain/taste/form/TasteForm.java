package com.std.sbb.domain.taste.form;

import com.std.sbb.global.jpa.BaseEntity;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class TasteForm extends BaseEntity {
    @NotEmpty
    private Integer sweet;
    @NotEmpty
    private Integer body;
    @NotEmpty
    private Integer acidity;
    @NotEmpty
    private Integer tannin;
}
