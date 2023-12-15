package com.std.sbb.domain.wine.service;

import com.std.sbb.domain.taste.entity.Taste;
import com.std.sbb.domain.wine.entity.Wine;
import com.std.sbb.domain.wine.repository.WineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WineService {
    private final WineRepository wineRepository;

    public void create(String wineName, String country, String list, Integer price, String kind, String food, String image, Taste taste){
        Wine wine = new Wine();
        wine.setWineName(wineName);
        wine.setCountry(country);
        wine.setList(list);
        wine.setPrice(price);
        wine.setKind(kind);
        wine.setFood(food);
        wine.setImage(image);
        wine.setTaste(taste);
        this.wineRepository.save(wine);
    }
}
