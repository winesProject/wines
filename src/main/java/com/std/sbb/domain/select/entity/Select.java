package com.std.sbb.domain.select.entity;

import com.std.sbb.domain.member.entity.Member;
import com.std.sbb.domain.wine.entity.Wine;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Select {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Member member;
    @OneToOne
    private Wine wine;
}
