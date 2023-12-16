package com.std.sbb.domain.wine.service;

import com.std.sbb.domain.taste.entity.Taste;
import com.std.sbb.domain.wine.entity.Wine;
import com.std.sbb.domain.wine.repository.WineRepository;
import com.std.sbb.global.genfile.service.GenFileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class WineService {
    private final WineRepository wineRepository;
    private final GenFileService genFileService;

    public void create(String wineName, String country, String list, Integer price, String kind, String food, MultipartFile image, Taste taste) {

        Wine wine = new Wine();
        wine.setWineName(wineName);
        wine.setCountry(country);
        wine.setList(list);
        wine.setPrice(price);
        wine.setKind(kind);
        wine.setFood(food);
        wine.setTaste(taste);


        if (image != null && !image.isEmpty()){
            Wine savedWine = this.wineRepository.save(wine);
            genFileService.save(savedWine.getWineName(), savedWine.getId(), "common", "image", 0, image);
        }else {
            System.out.println("이미 동일한 와인 이름이 존재합니다: " + wineName);
        }
    }
}