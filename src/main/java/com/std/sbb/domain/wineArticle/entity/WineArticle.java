package com.std.sbb.domain.wineArticle.entity;

import com.std.sbb.domain.review.entity.Review;
import com.std.sbb.domain.wine.entity.Wine;
import com.std.sbb.global.jpa.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

import java.util.List;

@Entity
@Getter
@Data
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
