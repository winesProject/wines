package com.std.sbb.domain.taste.entity;

import com.std.sbb.domain.wine.entity.Wine;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Taste {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer sweet;
    private Integer body;
    private Integer acidity;
    private Integer tannin;
    @OneToOne
    private Wine wine;
}
