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
    }

}
