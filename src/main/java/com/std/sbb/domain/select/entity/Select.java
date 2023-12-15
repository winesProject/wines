package com.std.sbb.domain.select.entity;

import com.std.sbb.domain.member.entity.Member;
import com.std.sbb.domain.wine.entity.Wine;
import com.std.sbb.global.jpa.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

@Entity
@Getter
@Data
public class Select extends BaseEntity {

    @ManyToOne
    private Member member;
    @OneToOne
    private Wine wine;
}
