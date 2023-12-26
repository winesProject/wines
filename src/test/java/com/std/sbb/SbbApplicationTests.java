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
                .food("소")
                .score(3)
                .kind("시라/쉬라즈, 마르셀란")
                .image("https://wine21.speedgabia.com/WINE_MST/TITLE/0176000/W0176250.png\n")
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
                .score(2)
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
                .score(5)
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
                .score(4)
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
                .score(5)
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
                .score(5)
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
                .score(3)
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
                .wineName("도멘 갸데, 레 뻬리에르 모노폴")
                .wineNameE("Domaine Gadias, Les Perrieres Monopole")
                .country("프랑스")
                .list("화이트")
                .price(0)
                .food("해산물, 치즈")
                .score(3)
                .kind("믈롱 드 부르고뉴 100%")
                .image("https://wine21.speedgabia.com/WINE_MST/TITLE/0166000/W0166571.jpg")
                .createDate(LocalDateTime.now())
                .taste(tasteService.create(2,3,4,1))
                .build();
        this.wineRepository.save(w);
    }
    @Test
    @DisplayName("와인 데이터")
    void test09() {
        Wine w = Wine.builder()
                .wineName("도멘 루 페레 에 피스, 생-토뱅 자디")
                .wineNameE("Domaine Roux Pere & Fils, Saint-Aubin Jadis")
                .country("프랑스")
                .list("화이트")
                .price(105000)
                .food("치킨, 해산물, 치즈, 양식, 중식 ")
                .score(4)
                .kind("샤르도네 100%")
                .image("https://wine21.speedgabia.com/WINE_MST/TITLE/0145000/W0145534.jpg")
                .createDate(LocalDateTime.now())
                .taste(tasteService.create(1,3,3,1))
                .build();
        this.wineRepository.save(w);
    }
    @Test
    @DisplayName("와인 데이터")
    void test10() {
        Wine w = Wine.builder()
                .wineName("도멘 뮈르뮈리움, 루싼느")
                .wineNameE("Domaine Mur Mur Ium, Roussanne")
                .country("프랑스")
                .list("화이트")
                .price(990000)
                .food("돼지, 해산물, 치킨, 치즈, 양식")
                .score(3)
                .kind("루산느 100%")
                .image("https://wine21.speedgabia.com/WINE_MST/TITLE/0153000/W0153563.jpg")
                .createDate(LocalDateTime.now())
                .taste(tasteService.create(1,3,3,1))
                .build();
        this.wineRepository.save(w);
    }
    @Test
    @DisplayName("와인 데이터")
    void test11() {
        Wine w = Wine.builder()
                .wineName("뤼나르, 브뤼")
                .wineNameE("Ruinart, Brut")
                .country("프랑스")
                .list("스파클링")
                .price(130000)
                .food("해산물, 치즈, 샐러드, 과일, 일식,디저트")
                .score(5)
                .kind("피노 누아, 샤르도네, 피노 뮈니에")
                .image("https://wine21.speedgabia.com/WINE_MST/TITLE/0143000/0143670.jpg")
                .createDate(LocalDateTime.now())
                .taste(tasteService.create(1,3,5,1))
                .build();
        this.wineRepository.save(w);
    }
    @Test
    @DisplayName("와인 데이터")
    void test12() {
        Wine w = Wine.builder()
                .wineName("메종 카스텔, 크레망 드 보르도 브뤼")
                .wineNameE("Maison Castel, Cremant de Bordeaux Brut")
                .country("프랑스")
                .list("스파클링")
                .price(40000)
                .food("디저트, 해산물")
                .score(4)
                .kind("세미용, 카베르네 프랑")
                .image("https://wine21.speedgabia.com/WINE_MST/TITLE/0170000/W0170694.png")
                .createDate(LocalDateTime.now())
                .taste(tasteService.create(1,1,3,1))
                .build();
        this.wineRepository.save(w);
    }
    @Test
    @DisplayName("와인 데이터")
    void test13() {
        Wine w = Wine.builder()
                .wineName("뻬에르 피터, 뀌베 스페셜 레 셔띠용")
                .wineNameE("Pierre Peters, Cuvee Speciale Les Chetillons")
                .country("프랑스")
                .list("스파클링")
                .price(342000)
                .food("해산물")
                .score(4)
                .kind("샤르도네")
                .image("https://wine21.speedgabia.com/WINE_MST/TITLE/0149000/W0149239.jpg")
                .createDate(LocalDateTime.now())
                .taste(tasteService.create(1,1,3,1))
                .build();
        this.wineRepository.save(w);
    }
    @Test
    @DisplayName("와인 데이터")
    void test14() {
        Wine w = Wine.builder()
                .wineName("샤를 뒤푸, 르 샴 뒤 끌로 블랑 드 블랑")
                .wineNameE("Charles Dufour, Le Champ du Clos Blanc de Blancs")
                .country("프랑스")
                .list("스파클링")
                .price(0)
                .food("해산물, 치즈, 샐러드, 일식, 한식, 과일, 디저트")
                .score(5)
                .kind("피노 블랑 100%")
                .image("https://wine21.speedgabia.com/WINE_MST/TITLE/0164000/W0164439.png")
                .createDate(LocalDateTime.now())
                .taste(tasteService.create(1,2,5,1))
                .build();
        this.wineRepository.save(w);
    }
    @Test
    @DisplayName("와인 데이터")
    void test15() {
        Wine w = Wine.builder()
                .wineName("샹파뉴 살롱 S")
                .wineNameE("Champagne Salon S")
                .country("프랑스")
                .list("스파클링")
                .price(990000)
                .food("치킨, 양, 치즈")
                .score(4)
                .kind("샤르도네 100%")
                .image("https://wine21.speedgabia.com/WINE_MST/TITLE/0147000/W0147378.jpg")
                .createDate(LocalDateTime.now())
                .taste(tasteService.create(1,4,4,1))
                .build();
        this.wineRepository.save(w);
    }
    @Test
    @DisplayName("와인 데이터")
    void test16() {
        Wine w = Wine.builder()
                .wineName("도츠, 아모르 드 도츠 로제")
                .wineNameE("Deutz, Amour de Deutz Rose")
                .country("프랑스")
                .list("로제")
                .price(780000)
                .food("해산물")
                .score(5)
                .kind("피노누아 70%, 샤르도네 30%")
                .image("https://wine21.speedgabia.com/WINE_MST/TITLE/0171000/W0171575.png")
                .createDate(LocalDateTime.now())
                .taste(tasteService.create(1,2,4,1))
                .build();
        this.wineRepository.save(w);
    }
    @Test
    @DisplayName("와인 데이터")
    void test17() {
        Wine w = Wine.builder()
                .wineName("베리 브라더스 & 러드, 프로방스 로제")
                .wineNameE("Berry Bros. & Rudd, Provence Rose")
                .country("프랑스")
                .list("로제")
                .price(18900)
                .food("치킨, 돼지, 해산물, 치즈, 양식")
                .score(4)
                .kind("그르나슈50%, 쌩쏘 30%, 시라.쉬라즈 10%, 무르베드르 10%")
                .image("https://wine21.speedgabia.com/WINE_MST/TITLE/0162000/W0162476.jpg")
                .createDate(LocalDateTime.now())
                .taste(tasteService.create(1,2,3,1))
                .build();
        this.wineRepository.save(w);
    }
    @Test
    @DisplayName("와인 데이터")
    void test18() {
        Wine w = Wine.builder()
                .wineName("빌라 로랑 로제 당주")
                .wineNameE("Villa Lorane Rose d'Anjou")
                .country("프랑스")
                .list("로제")
                .price(0)
                .food("중식, 일식, 한식")
                .score(3)
                .kind("카베르데 프랑 100%")
                .image("https://wine21.speedgabia.com/WINE_MST/TITLE/0165000/W0165947.jpg")
                .createDate(LocalDateTime.now())
                .taste(tasteService.create(2,3,3,1))
                .build();
        this.wineRepository.save(w);
    }
    @Test
    @DisplayName("와인 데이터")
    void test19() {
        Wine w = Wine.builder()
                .wineName("도멘 몽로즈, 솔리스 루멍 로제")
                .wineNameE("Domaine Montrose, Solis Lumen Rose")
                .country("프랑스")
                .list("로제")
                .price(50000)
                .food("중식, 일식, 한식")
                .score(5)
                .kind("카베르데 프랑 100%")
                .image("https://wine21.speedgabia.com/WINE_MST/TITLE/0165000/W0165947.jpg")
                .createDate(LocalDateTime.now())
                .taste(tasteService.create(2,3,3,1))
                .build();
        this.wineRepository.save(w);
    }
    // score값 위에 것들 추가해줘야함 ㅇㅇ
    @Test
    void testJpa() {
        for (int i = 1; i <= 100; i++) {
            String subject = String.format("테스트 데이터입니다:[%03d]", i);
            String content = "내용무";
            this.questionService.create(subject, content, null);
        }
    }
//    @Autowired
//    private EmailService emailService;
//    @Test
//    void testJpa1(){
//        this.emailService.send("gusrudchl12@gmail.com", "회원가입이 완료되었습니다.", "축하드립니다.");
//    }
}
