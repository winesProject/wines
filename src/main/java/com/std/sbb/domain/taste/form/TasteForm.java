package com.std.sbb.domain.taste.form;

import com.std.sbb.global.jpa.BaseEntity;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class TasteForm extends BaseEntity {
    private Integer sweet;
    private Integer body;
    private Integer acidity;
    private Integer tannin;
}
