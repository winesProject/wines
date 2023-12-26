package com.std.sbb.domain.favorites.entity;

import com.std.sbb.domain.member.entity.Member;
import com.std.sbb.domain.wine.entity.Wine;
import com.std.sbb.global.jpa.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Favorites extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;
    @OneToOne
    private Wine wine;
}
