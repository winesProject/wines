package com.std.sbb.domain.wineArticle.entity;

import com.std.sbb.domain.review.entity.Review;
import com.std.sbb.domain.wine.entity.Wine;
import com.std.sbb.global.jpa.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
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
    @ManyToOne
    private List<Review> reviewList;
}
