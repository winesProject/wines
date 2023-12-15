package com.std.sbb.domain.wine.entity;

import com.std.sbb.domain.select.entity.Select;
import com.std.sbb.domain.taste.entity.Taste;
import com.std.sbb.domain.wineArticle.entity.WineArticle;
import com.std.sbb.global.jpa.BaseEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

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
    @OneToOne(mappedBy = "wine")
    private Taste taste;
    @OneToOne(mappedBy = "wine", cascade = CascadeType.REMOVE)
    private WineArticle wineArticle;
}
