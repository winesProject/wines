package com.std.sbb;

import com.std.sbb.domain.question.service.QuestionService;
import com.std.sbb.domain.taste.service.TasteService;
import com.std.sbb.domain.wine.entity.Wine;
import com.std.sbb.domain.wine.repository.WineRepository;
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
    @Autowired
    private QuestionService questionService;
    @Test
    @DisplayName("와인 데이터")
    void test01() {
        Wine w = Wine.builder()
                .wineName("GCF, 꼬뜨 드 뵈프")
                .wineNameE("GCF, Cotes de Boeuf")
                .country("프랑스")
                .list("레드")
                .price(44000)
                .food("뵈프 부르기뇽, 안심 찹 스테이크, 로스트 비프 스테이크")
                .kind("시라/쉬라즈, 마르셀란")
                .image("../images/꼬뜨 드 뵈프.png")
                .createDate(LocalDateTime.now())
                .taste(tasteService.create(1,3,3,4))
                .build();
        this.wineRepository.save(w);
    }
    @Test
    @DisplayName("와인 데이터")
    void test02() {
        Wine w = Wine.builder()
                .wineName("기욤 르탕, 루비 루즈")
                .wineNameE("Guillaume Letang, Rubis Rouge")
                .country("프랑스")
                .list("레드")
                .price(0)
                .food("소고기, 스테이크, 불고기, 양꼬치, 족발, 한국음식, 피자, 햄버거")
                .kind("그르나슈")
                .image("https://wine21.speedgabia.com/WINE_MST/TITLE/0173000/W0173781.png")
                .createDate(LocalDateTime.now())
                .taste(tasteService.create(1,3,3,3))
                .build();
        this.wineRepository.save(w);
    }
    @Test
    @DisplayName("와인 데이터")
    void test03() {
        Wine w = Wine.builder()
                .wineName("도멘 마샹 프레르, 샹볼 뮈지니 프리미에르 크뤼 레 성띠에")
                .wineNameE("Domaine Marchand Freres, Chambolle-Musigny 1er Cru Les Sentiers")
                .country("프랑스")
                .list("레드")
                .price(0)
                .food("치즈")
                .kind("피노 누아 100%")
                .image("https://wine21.speedgabia.com/WINE_MST/TITLE/0162000/W0162049.jpg")
                .createDate(LocalDateTime.now())
                .taste(tasteService.create(1,3,4,2))
                .build();
        this.wineRepository.save(w);
    }
    @Test
    @DisplayName("와인 데이터")
    void test04() {
        Wine w = Wine.builder()
                .wineName("도멘 미쉘 그로, 본 로마네 프르미에 크뤼 '끌로 드 레아' 모노폴")
                .wineNameE("Domaine Michel Gros, Vosne Romanee 1er Cru 'Clos des Reas' Monopole")
                .country("프랑스")
                .list("레드")
                .price(760000)
                .food("치즈, 해산물")
                .kind("피노 누아 100%")
                .image("https://wine21.speedgabia.com/WINE_MST/IMAGE/0144000/T0144747_003.png")
                .createDate(LocalDateTime.now())
                .taste(tasteService.create(1,3,3,4))
                .build();
        this.wineRepository.save(w);
    }
    @Test
    @DisplayName("와인 데이터")
    void test05() {
        Wine w = Wine.builder()
                .wineName("도멘 페르드리 에세조 그랑 크뤼")
                .wineNameE("Domaine des Perdrix Echezeaux Grand Cru")
                .country("프랑스")
                .list("레드")
                .price(650000)
                .food("소, 치킨, 해산물, 치즈, 샐러드")
                .kind("피노 누아")
                .image("https://wine21.speedgabia.com/WINE_MST/TITLE/0158000/W0158959.jpg")
                .createDate(LocalDateTime.now())
                .taste(tasteService.create(1,3,4,3))
                .build();
        this.wineRepository.save(w);
    }
    @Test
    @DisplayName("와인 데이터")
    void test06() {
        Wine w = Wine.builder()
                .wineName("까브 드 루그니, 마콩 루그니 유진 블랑 샤르도네")
                .wineNameE("Cave de Lugny, Macon Lugny Eugene Blanc Chardonnay")
                .country("프랑스")
                .list("화이트")
                .price(75000)
                .food("치킨, 해산물, 치즈, 양식, 중식")
                .kind("샤르도네 100%")
                .image("https://wine21.speedgabia.com/WINE_MST/TITLE/0162000/W0162240.jpg")
                .createDate(LocalDateTime.now())
                .taste(tasteService.create(1,3,4,3))
                .build();
        this.wineRepository.save(w);
    }
    @Test
    @DisplayName("와인 데이터")
    void test07() {
        Wine w = Wine.builder()
                .wineName("도멘 그로 프레르 에 수르, 부르고뉴 오뜨 꼬뜨 드 뉘 블랑")
                .wineNameE("Domaine Gros Frere et Soeur, Bourgogne Hautes Cotes de Nuits Blanc")
                .country("프랑스")
                .list("화이트")
                .price(90000)
                .food("치킨, 해산물, 치즈, 양식, 중식")
                .kind("샤르도네 100%")
                .image("https://wine21.speedgabia.com/WINE_MST/TITLE/0145000/W0145534.jpg")
                .createDate(LocalDateTime.now())
                .taste(tasteService.create(1,3,4,3))
                .build();
        this.wineRepository.save(w);
    }
    @Test
    @DisplayName("와인 데이터")
    void test08() {
        Wine w = Wine.builder()
                .wineName("도멘 그로 프레르 에 수르, 부르고뉴 오뜨 꼬뜨 드 뉘 블랑 도멘 그로 프레르 에 수르, 부르고뉴 오뜨 꼬뜨 드 뉘 블랑")
                .wineNameE("Domaine Gros Frere et Soeur, Bourgogne Hautes Cotes de Nuits Blanc Domaine Gros Frere et Soeur, BourgogneDomaine Gros Frere et Soeur, Bourgogne")
                .country("프랑스")
                .list("화이트")
                .price(90000)
                .food("치킨, 해산물, 치즈, 양식, 중식")
                .kind("샤르도네 100%")
                .image("https://wine21.speedgabia.com/WINE_MST/TITLE/0145000/W0145534.jpg")
                .createDate(LocalDateTime.now())
                .taste(tasteService.create(1,3,4,3))
                .build();
        this.wineRepository.save(w);
    }

    @Test
    void testJpa() {
        for (int i = 1; i <= 100; i++) {
            String subject = String.format("테스트 데이터입니다:[%03d]", i);
            String content = "내용무";
            this.questionService.create(subject, content, null);
        }
    }
}
