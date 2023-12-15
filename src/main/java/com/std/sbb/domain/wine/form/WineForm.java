package com.std.sbb.domain.wine.form;

import com.std.sbb.domain.taste.entity.Taste;
import com.std.sbb.global.jpa.BaseEntity;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.Getter;

@Getter
@Data
public class WineForm extends BaseEntity {
    @NotEmpty(message = "필수")
    private String wineName;
    @NotEmpty(message = "필수")
    private String country;
    @NotEmpty(message = "필수")
    private String list;

    private Integer price;

    @NotEmpty(message = "필수")
    private String kind;

    private String food;

    private String image;

    private Taste taste;
}
