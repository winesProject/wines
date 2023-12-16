package com.std.sbb;

import com.std.sbb.domain.wine.entity.Wine;
import com.std.sbb.domain.wine.service.WineService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SbbApplicationTests {
    @Autowired
    private WineService wineService;

    @Test
    @DisplayName("와인 데이터 밀어넣기")
    void contextLoads() {
        Wine w = new Wine();
        w.setWineName("와인");
        w.setCountry("나라");
        w.setList("종류");
        w.setPrice(12345);
        w.setKind("품종");
        w.setFood("추천음식");
//        wine.setWineName(wineName);
//        wine.setCountry(country);
//        wine.setList(list);
//        wine.setPrice(price);
//        wine.setKind(kind);
//        wine.setFood(food);
//        wine.setImage(imagePath);
//        wine.setTaste(taste);
//        this.wineRepository.save(wine);
    }

}
