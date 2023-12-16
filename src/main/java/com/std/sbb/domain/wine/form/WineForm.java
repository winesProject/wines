package com.std.sbb.domain.wine.form;

import com.std.sbb.domain.taste.entity.Taste;
import com.std.sbb.global.jpa.BaseEntity;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;

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

    @NotNull(message = "Please provide an image")
    private MultipartFile image;

    private Taste taste;
}
