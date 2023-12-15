package com.std.sbb.domain.taste.entity;

import com.std.sbb.domain.wine.entity.Wine;
import com.std.sbb.global.jpa.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;

@Entity
@Getter
@Data
public class Taste extends BaseEntity {
    @Size(min = 1, max = 5)
    private Integer sweet;
    @Size(min = 1, max = 5)
    private Integer body;
    @Size(min = 1, max = 5)
    private Integer acidity;
    @Size(min = 1, max = 5)
    private Integer tannin;
    @OneToOne
    private Wine wine;
}
