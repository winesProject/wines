package com.std.sbb.domain.wine.form;

import com.std.sbb.domain.taste.entity.Taste;
import com.std.sbb.global.jpa.BaseEntity;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Data
public class WineForm{
    @NotEmpty(message = "와인 이름은 필수")
    private String wineName;
    @NotEmpty(message = "영어 와인 이름은 필수")
    private String wineNameE;
    @NotEmpty(message = "나라는 필수")
    private String country;
    @NotEmpty(message = "종류는 필수")
    private String list;

    private Integer price;

    @NotEmpty(message = "품종은 필수")
    private String kind;

    private String food;
    @NotNull(message = "평점을 작성해주세요")
    private Integer score;

    @NotNull(message = "Please provide an image")
    private MultipartFile image;

    private Taste taste;
}
