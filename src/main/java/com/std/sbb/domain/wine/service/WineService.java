package com.std.sbb.domain.wine.service;

import com.std.sbb.domain.taste.entity.Taste;
import com.std.sbb.domain.wine.entity.Wine;
import com.std.sbb.domain.wine.repository.WineRepository;
import com.std.sbb.global.genfile.service.GenFileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WineService {
    private final WineRepository wineRepository;
    private final GenFileService genFileService;

    public void create(String wineName, String country, String list, Integer price, String kind, String food, MultipartFile image, Taste taste) {
        Wine wine = Wine.builder()
                .wineName(wineName)
                .country(country)
                .list(list)
                .price(price)
                .kind(kind)
                .food(food)
                .taste(taste)
                .createDate(LocalDateTime.now())
                .build();
        this.wineRepository.save(wine);



        if (image != null && !image.isEmpty()){
            Wine savedWine = this.wineRepository.save(wine);
            genFileService.save(savedWine.getWineName(), savedWine.getId(), "common", "image", 0, image);
        }else {
            System.out.println("이미 동일한 와인 이름이 존재합니다: " + wineName);
        }
    }
    public List<Wine> getList() {
        return this.wineRepository.findAll();
    }

}