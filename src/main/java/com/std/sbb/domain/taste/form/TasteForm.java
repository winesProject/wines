package com.std.sbb.domain.taste.form;

import com.std.sbb.global.jpa.BaseEntity;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TasteForm{
    @NotNull(message = "Please provide a value for sweet")
    private Integer sweet;
    @NotNull(message = "Please provide a value for body")
    private Integer body;
    @NotNull(message = "Please provide a value for acidity")
    private Integer acidity;
    @NotNull(message = "Please provide a value for tannin")
    private Integer tannin;
}
