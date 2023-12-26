package com.std.sbb.domain.wine.form;

import com.std.sbb.domain.taste.entity.Taste;
import com.std.sbb.global.imagesfile.entity.Board;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class WineForm {
    @NotEmpty(message = "와인은 필수")
    private String wineName;
    @NotEmpty(message = "영어 와인 이름은 필수")
    private String wineNameE;
    @NotEmpty(message = "나라는 필수")
    private String country;
    @NotEmpty(message = "종류는 필수")
    private String list;

    private Integer price;

    @NotNull(message = "평점을 작성해주세요")
    private Integer score;

    @NotEmpty(message = "품종은 필수")
    private String kind;

    private String food;

    private MultipartFile image;

    private Board board;

    private Taste taste;
}
