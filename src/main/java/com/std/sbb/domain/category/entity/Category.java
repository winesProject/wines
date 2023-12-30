package com.std.sbb.domain.category.entity;

import com.std.sbb.domain.wine.entity.Wine;
import com.std.sbb.global.jpa.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Category extends BaseEntity {

    @ManyToMany
    private List<Wine> wines;

    private String wineList;

    public List<Wine> listWine(String list){
        List<Wine> newWine = new ArrayList<>();
        for (Wine w : wines){
            if (w.getList().equals(list)){
                newWine.add(w);
            } else {
                return wines;
            }
        }
        return newWine;
    }
}
