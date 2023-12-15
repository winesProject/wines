package com.std.sbb.domain.taste.entity;

import com.std.sbb.domain.wine.entity.Wine;
import com.std.sbb.global.jpa.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

@Entity
@Getter
@Data
public class Taste extends BaseEntity {

    private Integer sweet;
    private Integer body;
    private Integer acidity;
    private Integer tannin;
    @OneToOne
    private Wine wine;
}
