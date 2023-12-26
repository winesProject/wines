package com.std.sbb.domain.wine.entity;

import com.std.sbb.domain.member.entity.Member;
import com.std.sbb.domain.review.entity.Review;
import com.std.sbb.domain.taste.entity.Taste;
import com.std.sbb.global.jpa.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.util.List;
import java.util.Set;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@ToString
public class Wine extends BaseEntity {
    @Column(unique = true)
    private String wineName;
    @Column(unique = true)
    private String wineNameE;
    @Column(length = 100)
    private String country;
    @Column(length = 100)
    private String list;
    private Integer price;
    @Column(length = 200)
    private String kind;
    private String food;
    private String image;

    private Boolean favorites;

    @OneToOne(fetch = FetchType.LAZY)
    private Taste taste;

    @OneToMany(mappedBy = "wine", cascade = CascadeType.REMOVE)
    private List<Review> reviewList;

    @ManyToMany
    Set<Member> member;
}
