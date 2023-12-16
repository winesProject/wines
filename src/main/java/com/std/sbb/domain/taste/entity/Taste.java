package com.std.sbb.domain.taste.entity;

import com.std.sbb.domain.wine.entity.Wine;
import com.std.sbb.global.jpa.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Data;
import lombok.Getter;

@Entity
@Getter
@Data
public class Taste extends BaseEntity {
    @Min(value = 1)
    @Max(value = 5)
    private Integer sweet;
    @Min(value = 1)
    @Max(value = 5)
    private Integer body;
    @Min(value = 1)
    @Max(value = 5)
    private Integer acidity;
    @Min(value = 1)
    @Max(value = 5)
    private Integer tannin;
    @OneToOne
    private Wine wine;
}
