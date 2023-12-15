package com.std.sbb.domain.wine.entity;

import com.std.sbb.domain.select.entity.Select;
import com.std.sbb.domain.taste.entity.Taste;
import com.std.sbb.domain.wineArticle.entity.WineArticle;
import com.std.sbb.global.jpa.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Wine extends BaseEntity {
    @Column(unique = true)
    private String wineName;
    @Column(length = 100)
    private String country;
    @Column(length = 100)
    private String list;
    private Integer price;
    @Column(length = 200)
    private String kind;
    private String food;
    private String image;
    @OneToOne(mappedBy = "wine", cascade = CascadeType.REMOVE)
    private Select select;
    @OneToOne(mappedBy = "wine", cascade = CascadeType.REMOVE)
    private Taste taste;
    @OneToOne(mappedBy = "wine", cascade = CascadeType.REMOVE)
    private WineArticle wineArticle;
}
