package com.std.sbb.domain.wineArticle.entity;

import com.std.sbb.domain.review.entity.Review;
import com.std.sbb.domain.wine.entity.Wine;
import com.std.sbb.global.jpa.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
@Getter
public class WineArticle extends BaseEntity {
    @Column(length = 100)
    private String subject;
    @Column(columnDefinition = "TEXT")
    private String content;
    private String image;
    @OneToOne
    private Wine wine;
    @OneToMany(mappedBy = "wineArticle", cascade = CascadeType.REMOVE)
    private List<Review> reviewList;
}
