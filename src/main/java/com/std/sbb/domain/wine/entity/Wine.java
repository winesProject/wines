package com.std.sbb.domain.wine.entity;

import com.std.sbb.domain.member.entity.Member;
import com.std.sbb.domain.review.entity.Review;
import com.std.sbb.domain.taste.entity.Taste;
import com.std.sbb.global.imagesfile.entity.Board;
import com.std.sbb.global.jpa.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;
import java.util.Set;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Wine extends BaseEntity {
    @Column(unique = true)
    private String wineName;
    @Column(unique = true)
    private String wineNameE;
    @Column(length = 100)
    private String country;
    //국가
    @Column(length = 100)
    private String list;
    private Integer price;
    //가격
    @Column(length = 200)
    private String kind;
    //종류
    private Integer score;
    private String food;
    //음식
    private String image;

    @OneToOne
    private Board board;

    private Boolean favorites;

    @OneToOne(fetch = FetchType.LAZY)
    private Taste taste;

    @OneToMany(mappedBy = "wine", cascade = CascadeType.REMOVE)
    private List<Review> reviewList;

    @ManyToMany
    Set<Member> member;

    public boolean checkedHeartClickMember(String userName) {
        for (Member m : member) {
            if (userName.equals(m.getUsername())) {
                return true;
            }
        }
        return false;
    }

}