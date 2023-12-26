package com.std.sbb.domain.taste.form;

import com.std.sbb.global.jpa.BaseEntity;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TasteForm extends BaseEntity {
    @NotNull(message = "Please provide a value for sweet")
    private Integer sweet;
    @NotNull(message = "Please provide a value for sweet")
    private Integer body;
    @NotNull(message = "Please provide a value for sweet")
    private Integer acidity;
    @NotNull(message = "Please provide a value for sweet")
    private Integer tannin;
}
