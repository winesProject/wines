package com.std.sbb;

import com.std.sbb.domain.taste.entity.Taste;
import com.std.sbb.domain.taste.service.TasteService;
import com.std.sbb.domain.wine.entity.Wine;
import com.std.sbb.domain.wine.repository.WineRepository;
import com.std.sbb.domain.wine.service.WineService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
class SbbApplicationTests {
    @Autowired
    private WineRepository wineRepository;
    @Autowired
    private TasteService tasteService;
    @Test
    @DisplayName("와인 데이터")
    void test01() {
        Wine w = Wine.builder()
                .wineName("GCF, 꼬뜨 드 뵈프\n" +
                        "GCF, Cotes de Boeuf")
                .country("프랑스")
                .list("레드")
                .price(44000)
                .food("뵈프 부르기뇽, 안심 찹 스테이크, 로스트 비프 스테이크")
                .kind("시라/쉬라즈, 마르셀란")
                .image("../images/꼬뜨 드 뵈프.png")
                .createDate(LocalDateTime.now())
                .taste(tasteService.create(1,3,3,2))
                .build();
        this.wineRepository.save(w);
    }

}
