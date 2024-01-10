package com.std.sbb;

import com.std.sbb.domain.question.service.QuestionService;
import com.std.sbb.domain.taste.service.TasteService;
import com.std.sbb.domain.wine.entity.Wine;
import com.std.sbb.domain.wine.repository.WineRepository;
import com.std.sbb.global.imagesfile.entity.Board;
import com.std.sbb.global.imagesfile.service.BoardService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
class SbbApplicationTests {
    @Autowired
    private BoardService boardService;
    @Autowired
    private WineRepository wineRepository;
    @Autowired
    private TasteService tasteService;
    @Autowired
    private QuestionService questionService;


    @Test
    @DisplayName("와인 데이터")
    void test01() throws Exception {
        String filePath1 = "/static/images/GCF, 꼬뜨 드 뵈프.png"; // 클래스패스 상의 경로
        // 파일 경로에서 InputStream 생성
        InputStream inputStream1 = getClass().getResourceAsStream(filePath1);
        byte[] content = inputStream1.readAllBytes();
        MultipartFile multipartFile = new MockMultipartFile("file", "GCF, 꼬뜨 드 뵈프.png", "image/png", content);
        List<Board> boards = boardService.addBoard(List.of(multipartFile));

        for (Board board : boards) {
            Wine w = Wine.builder()
                    .wineName("GCF, 꼬뜨 드 뵈프")
                    .wineNameE("GCF, Cotes de Boeuf")
                    .country("프랑스")
                    .list("레드")
                    .price(44000)
                    .food("소")
                    .score(3)
                    .kind("시라/쉬라즈, 마르셀란")
                    .board(board)
                    .createDate(LocalDateTime.now())
                    .taste(tasteService.create(1, 3, 3, 2))
                    .build();
            this.wineRepository.save(w);
        }
    }
    @Test
    @DisplayName("와인 데이터 프랑스 레드")
    void test02() throws Exception {
        String filePath1 = "/static/images/도멘 미쉘 그로, 본 로마네 프르미에 크뤼 '끌로 드 레아' 모노폴.png"; // 클래스패스 상의 경로
        // 파일 경로에서 InputStream 생성
        InputStream inputStream = getClass().getResourceAsStream(filePath1);
        byte[] content = inputStream.readAllBytes();
        MultipartFile multipartFile = new MockMultipartFile("file", "도멘 미쉘 그로, 본 로마네 프르미에 크뤼 '끌로 드 레아' 모노폴.png", "image/png", content);
        List<Board> boards = boardService.addBoard(List.of(multipartFile));

        for (Board board : boards) {
            Wine w = Wine.builder()
                    .wineName("도멘 미쉘 그로, 본 로마네 프르미에 크뤼 '끌로 드 레아' 모노폴")
                    .wineNameE("Domaine Michel Gros, Vosne Romanee 1er Cru 'Clos des Reas' Monopole")
                    .country("프랑스")
                    .list("레드")
                    .price(760000)
                    .food("치즈,생선회,해산물")
                    .score(4)
                    .kind("피노 누아")
                    .board(board)
                    .createDate(LocalDateTime.now())
                    .taste(tasteService.create(1, 3, 3, 4))
                    .build();
            this.wineRepository.save(w);
        }
    }
    @Test
    @DisplayName("와인 데이터 프랑스 화이트")
    void test03() throws Exception {
        String filePath1 = "/static/images/까브 드 루그니, 마콩 루그니 유진 블랑 샤르도네_FW.jpg"; // 클래스패스 상의 경로
        // 파일 경로에서 InputStream 생성
        InputStream inputStream = getClass().getResourceAsStream(filePath1);
        byte[] content = inputStream.readAllBytes();
        MultipartFile multipartFile = new MockMultipartFile("file", "까브 드 루그니, 마콩 루그니 유진 블랑 샤르도네_FW.jpg", "image/jpeg", content);
        List<Board> boards = boardService.addBoard(List.of(multipartFile));

        for (Board board : boards) {
            Wine w = Wine.builder()
                    .wineName("까브 드 루그니, 마콩 루그니 유진 블랑 샤르도네")
                    .wineNameE("Cave de Lugny, Macon Lugny Eugene Blanc Chardonnay")
                    .country("프랑스")
                    .list("화이트")
                    .price(75000)
                    .food("치즈,생선회,해산물,샐러드")
                    .score(5)
                    .kind("샤르도네")
                    .board(board)
                    .createDate(LocalDateTime.now())
                    .taste(tasteService.create(1, 3, 4, 1))
                    .build();
            this.wineRepository.save(w);
        }
    }
    @Test
    @DisplayName("와인 데이터 프랑스 화이트")
    void test04() throws Exception {
        String filePath1 = "/static/images/도멘 그로 프레르 에 수르, 부르고뉴 오뜨 꼬뜨 드 뉘 블랑 FW.jpg"; // 클래스패스 상의 경로
        // 파일 경로에서 InputStream 생성
        InputStream inputStream = getClass().getResourceAsStream(filePath1);
        byte[] content = inputStream.readAllBytes();
        MultipartFile multipartFile = new MockMultipartFile("file", "도멘 그로 프레르 에 수르, 부르고뉴 오뜨 꼬뜨 드 뉘 블랑 FW.jpg", "image/jpeg", content);
        List<Board> boards = boardService.addBoard(List.of(multipartFile));

        for (Board board : boards) {
            Wine w = Wine.builder()
                    .wineName("도멘 그로 프레르 에 수르, 부르고뉴 오뜨 꼬뜨 드 뉘 블랑")
                    .wineNameE("Domaine Gros Frere et Soeur, Bourgogne Hautes Cotes de Nuits Blanc")
                    .country("프랑스")
                    .list("화이트")
                    .price(90000)
                    .food("치즈,생선회,해산물,샐러드,과일,디저트")
                    .score(5)
                    .kind("샤르도네")
                    .board(board)
                    .createDate(LocalDateTime.now())
                    .taste(tasteService.create(1, 3, 5, 1))
                    .build();
            this.wineRepository.save(w);
        }
    }

    @Test
    @DisplayName("와인 데이터 프랑스 스파클링")
    void test05() throws Exception {
        String filePath1 = "/static/images/FS 뤼나르, 브뤼.jpg"; // 클래스패스 상의 경로
        // 파일 경로에서 InputStream 생성
        InputStream inputStream = getClass().getResourceAsStream(filePath1);
        byte[] content = inputStream.readAllBytes();
        MultipartFile multipartFile = new MockMultipartFile("file", "FS 뤼나르, 브뤼.jpg", "image/jpeg", content);
        List<Board> boards = boardService.addBoard(List.of(multipartFile));

        for (Board board : boards) {
            Wine w = Wine.builder()
                    .wineName("뤼나르, 브뤼")
                    .wineNameE("Ruinart, Brut")
                    .country("프랑스")
                    .list("스파클링")
                    .price(130000)
                    .food("치즈,생선회,해산물,샐러드,과일,디저트")
                    .score(5)
                    .kind("피노 누아, 샤르도네, 피노 뮈니에")
                    .board(board)
                    .createDate(LocalDateTime.now())
                    .taste(tasteService.create(1, 3, 5, 1))
                    .build();
            this.wineRepository.save(w);
        }
    }
    @Test
    @DisplayName("와인 데이터 프랑스 스파클링")
    void test06() throws Exception {
        String filePath1 = "/static/images/FS 메종 카스텔, 크레망 드 보르도 브뤼.png"; // 클래스패스 상의 경로
        // 파일 경로에서 InputStream 생성
        InputStream inputStream = getClass().getResourceAsStream(filePath1);
        byte[] content = inputStream.readAllBytes();
        MultipartFile multipartFile = new MockMultipartFile("file", "FS 메종 카스텔, 크레망 드 보르도 브뤼.png", "image/png", content);
        List<Board> boards = boardService.addBoard(List.of(multipartFile));

        for (Board board : boards) {
            Wine w = Wine.builder()
                    .wineName("메종 카스텔, 크레망 드 보르도 브뤼")
                    .wineNameE("Maison Castel, Cremant de Bordeaux Brut")
                    .country("프랑스")
                    .list("스파클링")
                    .price(40000)
                    .food("해산물")
                    .score(5)
                    .kind("세미용, 카베르네 프랑")
                    .board(board)
                    .createDate(LocalDateTime.now())
                    .taste(tasteService.create(1, 1, 3, 1))
                    .build();
            this.wineRepository.save(w);
        }
    }

    @Test
    @DisplayName("와인 데이터 프랑스 로제")
    void test07() throws Exception {
        String filePath1 = "/static/images/FR 도츠, 아모르 드 도츠 로제.png"; // 클래스패스 상의 경로
        // 파일 경로에서 InputStream 생성
        InputStream inputStream = getClass().getResourceAsStream(filePath1);
        byte[] content = inputStream.readAllBytes();
        MultipartFile multipartFile = new MockMultipartFile("file", "FR 도츠, 아모르 드 도츠 로제.png", "image/png", content);
        List<Board> boards = boardService.addBoard(List.of(multipartFile));

        for (Board board : boards) {
            Wine w = Wine.builder()
                    .wineName("도츠, 아모르 드 도츠 로제")
                    .wineNameE("Deutz, Amour de Deutz Rose")
                    .country("프랑스")
                    .list("로제")
                    .price(780000)
                    .food("해산물,생선회")
                    .score(4)
                    .kind("피노누아 70%, 샤르도네 30%")
                    .board(board)
                    .createDate(LocalDateTime.now())
                    .taste(tasteService.create(1, 2, 4, 1))
                    .build();
            this.wineRepository.save(w);
        }
    }
    @Test
    @DisplayName("와인 데이터 프랑스 로제")
    void test08() throws Exception {
        String filePath1 = "/static/images/FR 베리 브라더스 & 러드, 프로방스 로제.jpg"; // 클래스패스 상의 경로
        // 파일 경로에서 InputStream 생성
        InputStream inputStream = getClass().getResourceAsStream(filePath1);
        byte[] content = inputStream.readAllBytes();
        MultipartFile multipartFile = new MockMultipartFile("file", "FR 베리 브라더스 & 러드, 프로방스 로제.jpg", "image/jpeg", content);
        List<Board> boards = boardService.addBoard(List.of(multipartFile));

        for (Board board : boards) {
            Wine w = Wine.builder()
                    .wineName("베리 브라더스 & 러드, 프로방스 로제")
                    .wineNameE("Berry Bros. & Rudd, Provence Rose")
                    .country("프랑스")
                    .list("로제")
                    .price(18900)
                    .food("닭,해산물,생선회,치즈,돼지")
                    .score(4)
                    .kind("그르나슈50%, 쌩쏘 30%, 시라.쉬라즈 10%, 무르베드르 10%")
                    .board(board)
                    .createDate(LocalDateTime.now())
                    .taste(tasteService.create(1, 2, 4, 1))
                    .build();
            this.wineRepository.save(w);
        }
    }
    @Test
    @DisplayName("와인 데이터 프랑스 주정강화")
    void test09() throws Exception {
        String filePath1 = "/static/images/FJ 샤또 롬보.png"; // 클래스패스 상의 경로
        // 파일 경로에서 InputStream 생성
        InputStream inputStream = getClass().getResourceAsStream(filePath1);
        byte[] content = inputStream.readAllBytes();
        MultipartFile multipartFile = new MockMultipartFile("file", "FJ 샤또 롬보.png", "image/png", content);
        List<Board> boards = boardService.addBoard(List.of(multipartFile));

        for (Board board : boards) {
            Wine w = Wine.builder()
                    .wineName("샤또 롬보")
                    .wineNameE("Chateau Rombeau")
                    .country("프랑스")
                    .list("주정강화")
                    .price(160000)
                    .food("치즈,디저트")
                    .score(5)
                    .kind("시라/쉬라즈, 무르베드르")
                    .board(board)
                    .createDate(LocalDateTime.now())
                    .taste(tasteService.create(5, 5, 3, 3))
                    .build();
            this.wineRepository.save(w);
        }
    }
    @Test
    @DisplayName("와인 데이터 프랑스 주정강화")
    void test10() throws Exception {
        String filePath1 = "/static/images/FJ 샤또 롱보, 리브잘트 앙브레.png"; // 클래스패스 상의 경로
        // 파일 경로에서 InputStream 생성
        InputStream inputStream = getClass().getResourceAsStream(filePath1);
        byte[] content = inputStream.readAllBytes();
        MultipartFile multipartFile = new MockMultipartFile("file", "FJ 샤또 롱보, 리브잘트 앙브레.png", "image/png", content);
        List<Board> boards = boardService.addBoard(List.of(multipartFile));

        for (Board board : boards) {
            Wine w = Wine.builder()
                    .wineName("샤또 롱보, 리브잘트 앙브레")
                    .wineNameE("Château Rombeau, Rivesaltes Ambre")
                    .country("프랑스")
                    .list("주정강화")
                    .price(69000)
                    .food("치즈,디저트")
                    .score(5)
                    .kind("시라/쉬라즈, 무르베드르")
                    .board(board)
                    .createDate(LocalDateTime.now())
                    .taste(tasteService.create(5, 5, 3, 1))
                    .build();
            this.wineRepository.save(w);
        }
    }
    @Test
    @DisplayName("와인 데이터 이탈리아 레드")
    void test11() throws Exception {
        String filePath1 = "/static/images/IR 리베토, 바롤로 세라룽가 달바.jpg"; // 클래스패스 상의 경로
        // 파일 경로에서 InputStream 생성
        InputStream inputStream = getClass().getResourceAsStream(filePath1);
        byte[] content = inputStream.readAllBytes();
        MultipartFile multipartFile = new MockMultipartFile("file", "IR 리베토, 바롤로 세라룽가 달바.jpg", "image/jpeg", content);
        List<Board> boards = boardService.addBoard(List.of(multipartFile));

        for (Board board : boards) {
            Wine w = Wine.builder()
                    .wineName("리베토, 바롤로 세라룽가 달바")
                    .wineNameE("Rivetto, Barolo del comune di Serralunga d'Alba")
                    .country("이탈리아")
                    .list("레드")
                    .price(180000)
                    .food("돼지,디저트")
                    .score(4)
                    .kind("네비올로 100%")
                    .board(board)
                    .createDate(LocalDateTime.now())
                    .taste(tasteService.create(1, 4, 4, 4))
                    .build();
            this.wineRepository.save(w);
        }
    }
    @Test
    @DisplayName("와인 데이터 이탈리아 레드")
    void test12() throws Exception {
        String filePath1 = "/static/images/IR  마라미에로, 인페리.jpg"; // 클래스패스 상의 경로
        // 파일 경로에서 InputStream 생성
        InputStream inputStream = getClass().getResourceAsStream(filePath1);
        byte[] content = inputStream.readAllBytes();
        MultipartFile multipartFile = new MockMultipartFile("file", "IR  마라미에로, 인페리.jpg", "image/jpeg", content);
        List<Board> boards = boardService.addBoard(List.of(multipartFile));

        for (Board board : boards) {
            Wine w = Wine.builder()
                    .wineName("마라미에로, 인페리")
                    .wineNameE("Marramiero, Inferi")
                    .country("이탈리아")
                    .list("레드")
                    .price(157000)
                    .food("샐러드,디저트")
                    .score(4)
                    .kind("몬테풀치아노 100%")
                    .board(board)
                    .createDate(LocalDateTime.now())
                    .taste(tasteService.create(1, 4, 3, 4))
                    .build();
            this.wineRepository.save(w);
        }
    }
    @Test
    @DisplayName("와인 데이터 이탈리아 화이트")
    void test13() throws Exception {
        String filePath1 = "/static/images/IW  깐티네 포베로, 모스카토 다스티 '캄포 델 팔리오'.jpg"; // 클래스패스 상의 경로
        // 파일 경로에서 InputStream 생성
        InputStream inputStream = getClass().getResourceAsStream(filePath1);
        byte[] content = inputStream.readAllBytes();
        MultipartFile multipartFile = new MockMultipartFile("file", "IW  깐티네 포베로, 모스카토 다스티 '캄포 델 팔리오'.jpg", "image/jpeg", content);
        List<Board> boards = boardService.addBoard(List.of(multipartFile));

        for (Board board : boards) {
            Wine w = Wine.builder()
                    .wineName("깐티네 포베로, 모스카토 다스티 '캄포 델 팔리오'")
                    .wineNameE("Cantine Povero, Moscato d'Asti 'Campo del Palio'")
                    .country("이탈리아")
                    .list("화이트")
                    .price(34000)
                    .food("샐러드,디저트,치즈")
                    .score(4)
                    .kind("모스카토 100%")
                    .board(board)
                    .createDate(LocalDateTime.now())
                    .taste(tasteService.create(4, 2, 2, 1))
                    .build();
            this.wineRepository.save(w);
        }
    }
    @Test
    @DisplayName("와인 데이터 이탈리아 화이트")
    void test14() throws Exception {
        String filePath1 = "/static/images/IW 다리오 프린칙, 트레베즈 리제르바.png"; // 클래스패스 상의 경로
        // 파일 경로에서 InputStream 생성
        InputStream inputStream = getClass().getResourceAsStream(filePath1);
        byte[] content = inputStream.readAllBytes();
        MultipartFile multipartFile = new MockMultipartFile("file", "IW 다리오 프린칙, 트레베즈 리제르바.png", "image/png", content);
        List<Board> boards = boardService.addBoard(List.of(multipartFile));

        for (Board board : boards) {
            Wine w = Wine.builder()
                    .wineName("다리오 프린칙, 트레베즈 리제르바")
                    .wineNameE("Dario Princic, Trebez Riserva")
                    .country("이탈리아")
                    .list("화이트")
                    .price(230000)
                    .food("샐러드,디저트,치즈,돼지,닭")
                    .score(5)
                    .kind("모스카토 100%")
                    .board(board)
                    .createDate(LocalDateTime.now())
                    .taste(tasteService.create(1, 3, 4, 2))
                    .build();
            this.wineRepository.save(w);
        }
    }
    @Test
    @DisplayName("와인 데이터 이탈리아 스파클링")
    void test15() throws Exception {
        String filePath1 = "/static/images/IS 베리 브라더스 & 러드, 프로세코.jpg"; // 클래스패스 상의 경로
        // 파일 경로에서 InputStream 생성
        InputStream inputStream = getClass().getResourceAsStream(filePath1);
        byte[] content = inputStream.readAllBytes();
        MultipartFile multipartFile = new MockMultipartFile("file", "IS 베리 브라더스 & 러드, 프로세코.jpg", "image/jpeg", content);
        List<Board> boards = boardService.addBoard(List.of(multipartFile));

        for (Board board : boards) {
            Wine w = Wine.builder()
                    .wineName("베리 브라더스 & 러드, 프로세코")
                    .wineNameE("Berry Bros. & Rudd, Prosecco")
                    .country("이탈리아")
                    .list("스파클링")
                    .price(18900)
                    .food("생선,디저트")
                    .score(5)
                    .kind("글레라 100%")
                    .board(board)
                    .createDate(LocalDateTime.now())
                    .taste(tasteService.create(1, 3, 3, 1))
                    .build();
            this.wineRepository.save(w);
        }
    }
    @Test
    @DisplayName("와인 데이터 이탈리아 로제")
    void test16() throws Exception {
        String filePath1 = "/static/images/IRo 바바, 로제타.jpg"; // 클래스패스 상의 경로
        // 파일 경로에서 InputStream 생성
        InputStream inputStream = getClass().getResourceAsStream(filePath1);
        byte[] content = inputStream.readAllBytes();
        MultipartFile multipartFile = new MockMultipartFile("file", "IRo 바바, 로제타.jpg", "image/jpeg", content);
        List<Board> boards = boardService.addBoard(List.of(multipartFile));

        for (Board board : boards) {
            Wine w = Wine.builder()
                    .wineName("바바, 로제타")
                    .wineNameE("Bava, Rosetta")
                    .country("이탈리아")
                    .list("로제")
                    .price(51000)
                    .food("디저트")
                    .score(5)
                    .kind("말바시아 디 스키에라노 100%")
                    .board(board)
                    .createDate(LocalDateTime.now())
                    .taste(tasteService.create(4, 3, 1, 1))
                    .build();
            this.wineRepository.save(w);
        }
    }
    @Test
    @DisplayName("와인 데이터 이탈리아 로제")
    void test17() throws Exception {
        String filePath1 = "/static/images/IRo 자카니니, 체라수올로 다브루쪼.png"; // 클래스패스 상의 경로
        // 파일 경로에서 InputStream 생성
        InputStream inputStream = getClass().getResourceAsStream(filePath1);
        byte[] content = inputStream.readAllBytes();
        MultipartFile multipartFile = new MockMultipartFile("file", "IRo 자카니니, 체라수올로 다브루쪼.png", "image/png", content);
        List<Board> boards = boardService.addBoard(List.of(multipartFile));

        for (Board board : boards) {
            Wine w = Wine.builder()
                    .wineName("자카니니, 체라수올로 다브루쪼")
                    .wineNameE("Zaccagnini, Cerasuolo d'Aburzzo")
                    .country("이탈리아")
                    .list("로제")
                    .price(55000)
                    .food("디저트,생선회")
                    .score(4)
                    .kind("몬테풀치아노 100%")
                    .board(board)
                    .createDate(LocalDateTime.now())
                    .taste(tasteService.create(1, 2, 3, 1))
                    .build();
            this.wineRepository.save(w);
        }
    }
    @Test
    @DisplayName("와인 데이터 이탈리아 주정강화")
    void test18() throws Exception {
        String filePath1 = "/static/images/IJ 카를로 펠레그리노, 마르살라 수페리오레 가리발디 돌체.jpg"; // 클래스패스 상의 경로
        // 파일 경로에서 InputStream 생성
        InputStream inputStream = getClass().getResourceAsStream(filePath1);
        byte[] content = inputStream.readAllBytes();
        MultipartFile multipartFile = new MockMultipartFile("file", "IJ 카를로 펠레그리노, 마르살라 수페리오레 가리발디 돌체.jpg", "image/jpeg", content);
        List<Board> boards = boardService.addBoard(List.of(multipartFile));

        for (Board board : boards) {
            Wine w = Wine.builder()
                    .wineName("카를로 펠레그리노, 마르살라 수페리오레 가리발디 돌체")
                    .wineNameE("Carlo Pellegrino, Marsala Superiore Garibaldi Dolce")
                    .country("이탈리아")
                    .list("주정강화")
                    .price(40000)
                    .food("디저트")
                    .score(5)
                    .kind("그릴로, 카타라토, 인졸리아")
                    .board(board)
                    .createDate(LocalDateTime.now())
                    .taste(tasteService.create(5, 5, 2, 1))
                    .build();
            this.wineRepository.save(w);
        }
    }
    @Test
    @DisplayName("와인 데이터 이탈리아 주정강화")
    void test19() throws Exception {
        String filePath1 = "/static/images/IJ 카사노 마르살라 파인.jpg"; // 클래스패스 상의 경로
        // 파일 경로에서 InputStream 생성
        InputStream inputStream = getClass().getResourceAsStream(filePath1);
        byte[] content = inputStream.readAllBytes();
        MultipartFile multipartFile = new MockMultipartFile("file", "IJ 카사노 마르살라 파인.jpg", "image/jpeg", content);
        List<Board> boards = boardService.addBoard(List.of(multipartFile));

        for (Board board : boards) {
            Wine w = Wine.builder()
                    .wineName("카사노 마르살라 파인")
                    .wineNameE("Casano Marsala Fine")
                    .country("이탈리아")
                    .list("주정강화")
                    .price(39000)
                    .food("디저트")
                    .score(5)
                    .kind("카타라토, 그릴로, 인졸리아")
                    .board(board)
                    .createDate(LocalDateTime.now())
                    .taste(tasteService.create(5, 5, 2, 2))
                    .build();
            this.wineRepository.save(w);
        }
    }
    @Test
    @DisplayName("와인 데이터 스페인 레드")
    void test20() throws Exception {
        String filePath1 = "/static/images/SR 라몬 빌바오, 그랑 리제르바.jpg"; // 클래스패스 상의 경로
        // 파일 경로에서 InputStream 생성
        InputStream inputStream = getClass().getResourceAsStream(filePath1);
        byte[] content = inputStream.readAllBytes();
        MultipartFile multipartFile = new MockMultipartFile("file", "SR 라몬 빌바오, 그랑 리제르바.jpg", "image/jpeg", content);
        List<Board> boards = boardService.addBoard(List.of(multipartFile));

        for (Board board : boards) {
            Wine w = Wine.builder()
                    .wineName("라몬 빌바오, 그랑 리제르바")
                    .wineNameE("Ramon Bilbao, Gran Reserva")
                    .country("스페인")
                    .list("레드")
                    .price(92000)
                    .food("돼지,소,치즈")
                    .score(3)
                    .kind("템프라니요 90%, 그라시아노 5%, 가르나차 5%")
                    .board(board)
                    .createDate(LocalDateTime.now())
                    .taste(tasteService.create(1, 4, 3, 3))
                    .build();
            this.wineRepository.save(w);
        }
    }
    @Test
    @DisplayName("와인 데이터 스페인 레드")
    void test21() throws Exception {
        String filePath1 = "/static/images/SR 무쏘 메를로.jpg"; // 클래스패스 상의 경로
        // 파일 경로에서 InputStream 생성
        InputStream inputStream = getClass().getResourceAsStream(filePath1);
        byte[] content = inputStream.readAllBytes();
        MultipartFile multipartFile = new MockMultipartFile("file", "SR 무쏘 메를로.jpg", "image/jpeg", content);
        List<Board> boards = boardService.addBoard(List.of(multipartFile));

        for (Board board : boards) {
            Wine w = Wine.builder()
                    .wineName("무쏘 메를로")
                    .wineNameE("Musso Merlot")
                    .country("스페인")
                    .list("레드")
                    .price(35000)
                    .food("돼지,소,치즈")
                    .score(3)
                    .kind("메를로 100%")
                    .board(board)
                    .createDate(LocalDateTime.now())
                    .taste(tasteService.create(1, 4, 3, 3))
                    .build();
            this.wineRepository.save(w);
        }
    }
    @Test
    @DisplayName("와인 데이터 스페인 화이트")
    void test22() throws Exception {
        String filePath1 = "/static/images/SW 보데가스 무가, 블랑코.jpg"; // 클래스패스 상의 경로
        // 파일 경로에서 InputStream 생성
        InputStream inputStream = getClass().getResourceAsStream(filePath1);
        byte[] content = inputStream.readAllBytes();
        MultipartFile multipartFile = new MockMultipartFile("file", "SW 보데가스 무가, 블랑코.jpg", "image/jpeg", content);
        List<Board> boards = boardService.addBoard(List.of(multipartFile));

        for (Board board : boards) {
            Wine w = Wine.builder()
                    .wineName("보데가스 무가, 블랑코")
                    .wineNameE("Bodegas Muga, Blanco")
                    .country("스페인")
                    .list("화이트")
                    .price(70000)
                    .food("샐러드,해산물,돼지")
                    .score(4)
                    .kind("비우라 90%, 말바시아 10%")
                    .board(board)
                    .createDate(LocalDateTime.now())
                    .taste(tasteService.create(1, 3, 4, 1))
                    .build();
            this.wineRepository.save(w);
        }
    }
    @Test
    @DisplayName("와인 데이터 스페인 화이트")
    void test23() throws Exception {
        String filePath1 = "/static/images/SW 핀카 바카라, 예야.png"; // 클래스패스 상의 경로
        // 파일 경로에서 InputStream 생성
        InputStream inputStream = getClass().getResourceAsStream(filePath1);
        byte[] content = inputStream.readAllBytes();
        MultipartFile multipartFile = new MockMultipartFile("file", "SW 핀카 바카라, 예야.png", "image/png", content);
        List<Board> boards = boardService.addBoard(List.of(multipartFile));

        for (Board board : boards) {
            Wine w = Wine.builder()
                    .wineName("핀카 바카라, 예야")
                    .wineNameE("Finca Bacara, Yeya")
                    .country("스페인")
                    .list("화이트")
                    .price(40000)
                    .food("생선회,돼지")
                    .score(4)
                    .kind("샤르도네 50%, 모스카텔 50%")
                    .board(board)
                    .createDate(LocalDateTime.now())
                    .taste(tasteService.create(1, 3, 3, 1))
                    .build();
            this.wineRepository.save(w);
        }
    }

    @Test
    @DisplayName("와인 데이터 스페인 스파클링")
    void test24() throws Exception {
        String filePath1 = "/static/images/SS  본 샹스 모스카토 로제.jpg"; // 클래스패스 상의 경로
        // 파일 경로에서 InputStream 생성
        InputStream inputStream = getClass().getResourceAsStream(filePath1);
        byte[] content = inputStream.readAllBytes();
        MultipartFile multipartFile = new MockMultipartFile("file", "SS  본 샹스 모스카토 로제.jpg", "image/jpeg", content);
        List<Board> boards = boardService.addBoard(List.of(multipartFile));

        for (Board board : boards) {
            Wine w = Wine.builder()
                    .wineName("본 샹스 모스카토 로제")
                    .wineNameE("Bonne Chance Moscato Rose")
                    .country("스페인")
                    .list("스파클링")
                    .price(24000)
                    .food("생선회,돼지")
                    .score(3)
                    .kind("모스카토 100%")
                    .board(board)
                    .createDate(LocalDateTime.now())
                    .taste(tasteService.create(4, 2, 1, 1))
                    .build();
            this.wineRepository.save(w);
        }
    }
    @Test
    @DisplayName("와인 데이터 스페인 스파클링")
    void test25() throws Exception {
        String filePath1 = "/static/images/SS 뻬레 벤뚜라, 까바 브륏 레세르바 아트 에디션 화이트.jpg"; // 클래스패스 상의 경로
        // 파일 경로에서 InputStream 생성
        InputStream inputStream = getClass().getResourceAsStream(filePath1);
        byte[] content = inputStream.readAllBytes();
        MultipartFile multipartFile = new MockMultipartFile("file", "SS 뻬레 벤뚜라, 까바 브륏 레세르바 아트 에디션 화이트.jpg", "image/jpeg", content);
        List<Board> boards = boardService.addBoard(List.of(multipartFile));

        for (Board board : boards) {
            Wine w = Wine.builder()
                    .wineName("뻬레 벤뚜라, 까바 브륏 레세르바 아트 에디션 화이트")
                    .wineNameE("Pere Ventura, Cava Brut Reserva Art Edition White")
                    .country("스페인")
                    .list("스파클링")
                    .price(50000)
                    .food("샐러드,디저트,치즈")
                    .score(5)
                    .kind("자렐로 35%, 빠레야다 35%, 마카베오 30%")
                    .board(board)
                    .createDate(LocalDateTime.now())
                    .taste(tasteService.create(2, 3, 4, 1))
                    .build();
            this.wineRepository.save(w);
        }
    }
    @Test
    @DisplayName("와인 데이터 스페인 로제")
    void test26() throws Exception {
        String filePath1 = "/static/images/SRo 핀카 바카라, 로제.png"; // 클래스패스 상의 경로
        // 파일 경로에서 InputStream 생성
        InputStream inputStream = getClass().getResourceAsStream(filePath1);
        byte[] content = inputStream.readAllBytes();
        MultipartFile multipartFile = new MockMultipartFile("file", "SRo 핀카 바카라, 로제.png", "image/png", content);
        List<Board> boards = boardService.addBoard(List.of(multipartFile));

        for (Board board : boards) {
            Wine w = Wine.builder()
                    .wineName("핀카 바카라, 로제")
                    .wineNameE("Finca Bacara, Rose")
                    .country("스페인")
                    .list("로제")
                    .price(40000)
                    .food("생선회,돼지")
                    .score(3)
                    .kind("가르나차")
                    .board(board)
                    .createDate(LocalDateTime.now())
                    .taste(tasteService.create(1, 2, 3, 1))
                    .build();
            this.wineRepository.save(w);
        }
    }
    @Test
    @DisplayName("와인 데이터 스페인 로제")
    void test27() throws Exception {
        String filePath1 = "/static/images/SRo 베리 브라더스 & 러드, 더 머천트 로제.jpg"; // 클래스패스 상의 경로
        // 파일 경로에서 InputStream 생성
        InputStream inputStream = getClass().getResourceAsStream(filePath1);
        byte[] content = inputStream.readAllBytes();
        MultipartFile multipartFile = new MockMultipartFile("file", "SRo 베리 브라더스 & 러드, 더 머천트 로제.jpg", "image/jpeg", content);
        List<Board> boards = boardService.addBoard(List.of(multipartFile));

        for (Board board : boards) {
            Wine w = Wine.builder()
                    .wineName("베리 브라더스 & 러드, 더 머천트 로제")
                    .wineNameE("Berry Bros. & Rudd, The Merchant's Rose")
                    .country("스페인")
                    .list("로제")
                    .price(12900)
                    .food("생선회,돼지,해산물,치즈,디저트,소")
                    .score(3)
                    .kind("가르나츠 100%")
                    .board(board)
                    .createDate(LocalDateTime.now())
                    .taste(tasteService.create(1, 2, 3, 1))
                    .build();
            this.wineRepository.save(w);
        }
    }
    @Test
    @DisplayName("와인 데이터 스페인 주정강화")
    void test28() throws Exception {
        String filePath1 = "/static/images/SJ 곤잘레스 비야스 아포스톨레스 30년.jpg"; // 클래스패스 상의 경로
        // 파일 경로에서 InputStream 생성
        InputStream inputStream = getClass().getResourceAsStream(filePath1);
        byte[] content = inputStream.readAllBytes();
        MultipartFile multipartFile = new MockMultipartFile("file", "SJ 곤잘레스 비야스 아포스톨레스 30년.jpg", "image/jpeg", content);
        List<Board> boards = boardService.addBoard(List.of(multipartFile));

        for (Board board : boards) {
            Wine w = Wine.builder()
                    .wineName("곤잘레스 비야스 아포스톨레스 30년")
                    .wineNameE("Gonzales Byass Apostoles 30 years")
                    .country("스페인")
                    .list("주정강화")
                    .price(286000)
                    .food("돼지,치즈,소")
                    .score(5)
                    .kind("팔로미노 87%, 페드로 히메네스 13%")
                    .board(board)
                    .createDate(LocalDateTime.now())
                    .taste(tasteService.create(5, 5, 2, 2))
                    .build();
            this.wineRepository.save(w);
        }
    }
    @Test
    @DisplayName("와인 데이터 스페인 주정강화")
    void test29() throws Exception {
        String filePath1 = "/static/images/SJ 루스토, 이스트 인디아 솔레라.jpg"; // 클래스패스 상의 경로
        // 파일 경로에서 InputStream 생성
        InputStream inputStream = getClass().getResourceAsStream(filePath1);
        byte[] content = inputStream.readAllBytes();
        MultipartFile multipartFile = new MockMultipartFile("file", "SJ 루스토, 이스트 인디아 솔레라.jpg", "image/jpeg", content);
        List<Board> boards = boardService.addBoard(List.of(multipartFile));

        for (Board board : boards) {
            Wine w = Wine.builder()
                    .wineName("루스토, 이스트 인디아 솔레라")
                    .wineNameE("Lustau, East India Solera")
                    .country("스페인")
                    .list("주정강화")
                    .price(37000)
                    .food("치즈,디저트")
                    .score(4)
                    .kind("팔로미노, 페드로 히메네스")
                    .board(board)
                    .createDate(LocalDateTime.now())
                    .taste(tasteService.create(5, 5, 2, 2))
                    .build();
            this.wineRepository.save(w);
        }
    }
    @Test
    @DisplayName("와인 데이터 포르투갈 레드")
    void test30() throws Exception {
        String filePath1 = "/static/images/PR 프레익소, 테루아 레드.png"; // 클래스패스 상의 경로
        // 파일 경로에서 InputStream 생성
        InputStream inputStream = getClass().getResourceAsStream(filePath1);
        byte[] content = inputStream.readAllBytes();
        MultipartFile multipartFile = new MockMultipartFile("file", "PR 프레익소, 테루아 레드.png", "image/png", content);
        List<Board> boards = boardService.addBoard(List.of(multipartFile));

        for (Board board : boards) {
            Wine w = Wine.builder()
                    .wineName("프레익소, 테루아 레드")
                    .wineNameE("Freixo, Terroir Red")
                    .country("포르투갈")
                    .list("레드")
                    .price(72000)
                    .food("치즈,디저트")
                    .score(2)
                    .kind("알리칸테 부쉐, 투리가 나시오날, 카베르네 소비뇽")
                    .board(board)
                    .createDate(LocalDateTime.now())
                    .taste(tasteService.create(1, 3, 3, 3))
                    .build();
            this.wineRepository.save(w);
        }
    }
    @Test
    @DisplayName("와인 데이터 포르투갈 레드")
    void test31() throws Exception {
        String filePath1 = "/static/images/PR 비디갈 와이너리, 포르타 6 틴토.jpg"; // 클래스패스 상의 경로
        // 파일 경로에서 InputStream 생성
        InputStream inputStream = getClass().getResourceAsStream(filePath1);
        byte[] content = inputStream.readAllBytes();
        MultipartFile multipartFile = new MockMultipartFile("file", "PR 비디갈 와이너리, 포르타 6 틴토.jpg", "image/jpeg", content);
        List<Board> boards = boardService.addBoard(List.of(multipartFile));

        for (Board board : boards) {
            Wine w = Wine.builder()
                    .wineName("비디갈 와이너리, 포르타 6 틴토")
                    .wineNameE("Vidigal Winery, Porta 6 Tinto")
                    .country("포르투갈")
                    .list("레드")
                    .price(19000)
                    .food("치즈,디저트,돼지")
                    .score(4)
                    .kind("아라고네즈 50%, 카스텔라옹 40%, 투리가 나시오날 10%")
                    .board(board)
                    .createDate(LocalDateTime.now())
                    .taste(tasteService.create(1, 3, 3, 3))
                    .build();
            this.wineRepository.save(w);
        }
    }
    @Test
    @DisplayName("와인 데이터 포르투갈 화이트")
    void test32() throws Exception {
        String filePath1 = "/static/images/PW 아니무스 비뉴 베르데.png"; // 클래스패스 상의 경로
        // 파일 경로에서 InputStream 생성
        InputStream inputStream = getClass().getResourceAsStream(filePath1);
        byte[] content = inputStream.readAllBytes();
        MultipartFile multipartFile = new MockMultipartFile("file", "PW 아니무스 비뉴 베르데.png", "image/png", content);
        List<Board> boards = boardService.addBoard(List.of(multipartFile));

        for (Board board : boards) {
            Wine w = Wine.builder()
                    .wineName("아니무스 비뉴 베르데")
                    .wineNameE("Animus Vinho Verde")
                    .country("포르투갈")
                    .list("화이트")
                    .price(43000)
                    .food("생선회,해산물,치즈")
                    .score(2)
                    .kind("로우레이루, 아린토")
                    .board(board)
                    .createDate(LocalDateTime.now())
                    .taste(tasteService.create(1, 2, 3, 1))
                    .build();
            this.wineRepository.save(w);
        }
    }
    @Test
    @DisplayName("와인 데이터 포르투갈 화이트")
    void test33() throws Exception {
        String filePath1 = "/static/images/PW 아벨레다 루레이로 & 알바리뇨.png"; // 클래스패스 상의 경로
        // 파일 경로에서 InputStream 생성
        InputStream inputStream = getClass().getResourceAsStream(filePath1);
        byte[] content = inputStream.readAllBytes();
        MultipartFile multipartFile = new MockMultipartFile("file", "PW 아벨레다 루레이로 & 알바리뇨.png", "image/png", content);
        List<Board> boards = boardService.addBoard(List.of(multipartFile));

        for (Board board : boards) {
            Wine w = Wine.builder()
                    .wineName("아벨레다 루레이로 & 알바리뇨")
                    .wineNameE("Aveleda Loureiro & Albarinho")
                    .country("포르투갈")
                    .list("화이트")
                    .price(40000)
                    .food("생선회,샐러드,닭")
                    .score(4)
                    .kind("로우레이루 70%, 알바리뇨 30%")
                    .board(board)
                    .createDate(LocalDateTime.now())
                    .taste(tasteService.create(1, 3, 4, 1))
                    .build();
            this.wineRepository.save(w);
        }
    }
    @Test
    @DisplayName("와인 데이터 포르투갈 스파클링")
    void test34() throws Exception {
        String filePath1 = "/static/images/PS 까잘 가르시아, 비뉴 베르데 스파클링 화이트.jpg"; // 클래스패스 상의 경로
        // 파일 경로에서 InputStream 생성
        InputStream inputStream = getClass().getResourceAsStream(filePath1);
        byte[] content = inputStream.readAllBytes();
        MultipartFile multipartFile = new MockMultipartFile("file", "PS 까잘 가르시아, 비뉴 베르데 스파클링 화이트.jpg", "image/jpeg", content);
        List<Board> boards = boardService.addBoard(List.of(multipartFile));

        for (Board board : boards) {
            Wine w = Wine.builder()
                    .wineName("까잘 가르시아, 비뉴 베르데 스파클링 화이트")
                    .wineNameE("Casal Garcia, Vinho Verde Sparkling White")
                    .country("포르투갈")
                    .list("스파클링")
                    .price(40000)
                    .food("생선회,해산물")
                    .score(5)
                    .kind("로우레이루 70%, 알바리뇨 30%")
                    .board(board)
                    .createDate(LocalDateTime.now())
                    .taste(tasteService.create(2, 2, 4, 1))
                    .build();
            this.wineRepository.save(w);
        }
    }
    @Test
    @DisplayName("와인 데이터 포르투갈 스파클링")
    void test35() throws Exception {
        String filePath1 = "/static/images/PS 까잘 가르시아, 비뉴 베르데 스파클링 로제.jpg"; // 클래스패스 상의 경로
        // 파일 경로에서 InputStream 생성
        InputStream inputStream = getClass().getResourceAsStream(filePath1);
        byte[] content = inputStream.readAllBytes();
        MultipartFile multipartFile = new MockMultipartFile("file", "PS 까잘 가르시아, 비뉴 베르데 스파클링 로제.jpg", "image/jpeg", content);
        List<Board> boards = boardService.addBoard(List.of(multipartFile));

        for (Board board : boards) {
            Wine w = Wine.builder()
                    .wineName("까잘 가르시아, 비뉴 베르데 스파클링 로제")
                    .wineNameE("Casal Garcia, Vinho Verde Sparkling Rose")
                    .country("포르투갈")
                    .list("스파클링")
                    .price(40000)
                    .food("생선회,해산물")
                    .score(5)
                    .kind("비냐웅, 보하사라, 아잘 틴토")
                    .board(board)
                    .createDate(LocalDateTime.now())
                    .taste(tasteService.create(2, 2, 4, 1))
                    .build();
            this.wineRepository.save(w);
        }
    }
    @Test
    @DisplayName("와인 데이터 포르투갈 로제")
    void test36() throws Exception {
        String filePath1 = "/static/images/PRo 아소르스, 뷸카니코 로제.png"; // 클래스패스 상의 경로
        // 파일 경로에서 InputStream 생성
        InputStream inputStream = getClass().getResourceAsStream(filePath1);
        byte[] content = inputStream.readAllBytes();
        MultipartFile multipartFile = new MockMultipartFile("file", "PRo 아소르스, 뷸카니코 로제.png", "image/png", content);
        List<Board> boards = boardService.addBoard(List.of(multipartFile));

        for (Board board : boards) {
            Wine w = Wine.builder()
                    .wineName("아소르스, 뷸카니코 로제")
                    .wineNameE("Azores, Vulcanico Rose")
                    .country("포르투갈")
                    .list("로제")
                    .price(44000)
                    .food("생선회,해산물,샐러드")
                    .score(3)
                    .kind("블렌드")
                    .board(board)
                    .createDate(LocalDateTime.now())
                    .taste(tasteService.create(1, 2, 3, 1))
                    .build();
            this.wineRepository.save(w);
        }
    }
    @Test
    @DisplayName("와인 데이터 포르투갈 로제")
    void test37() throws Exception {
        String filePath1 = "/static/images/PRo 까잘 가르시아, 로제.png"; // 클래스패스 상의 경로
        // 파일 경로에서 InputStream 생성
        InputStream inputStream = getClass().getResourceAsStream(filePath1);
        byte[] content = inputStream.readAllBytes();
        MultipartFile multipartFile = new MockMultipartFile("file", "PRo 까잘 가르시아, 로제.png", "image/png", content);
        List<Board> boards = boardService.addBoard(List.of(multipartFile));

        for (Board board : boards) {
            Wine w = Wine.builder()
                    .wineName("까잘 가르시아, 로제")
                    .wineNameE("Casal Garcia, Rose")
                    .country("포르투갈")
                    .list("로제")
                    .price(30000)
                    .food("샐러드")
                    .score(4)
                    .kind("비냐웅, 아잘 틴토, 보하살")
                    .board(board)
                    .createDate(LocalDateTime.now())
                    .taste(tasteService.create(1, 2, 3, 2))
                    .build();
            this.wineRepository.save(w);
        }
    }
    @Test
    @DisplayName("와인 데이터 포르투갈 주정강화")
    void test38() throws Exception {
        String filePath1 = "/static/images/PJ 글로리아 토니 포트 와인.png"; // 클래스패스 상의 경로
        // 파일 경로에서 InputStream 생성
        InputStream inputStream = getClass().getResourceAsStream(filePath1);
        byte[] content = inputStream.readAllBytes();
        MultipartFile multipartFile = new MockMultipartFile("file", "PJ 글로리아 토니 포트 와인.png", "image/png", content);
        List<Board> boards = boardService.addBoard(List.of(multipartFile));

        for (Board board : boards) {
            Wine w = Wine.builder()
                    .wineName("글로리아 토니 포트 와인")
                    .wineNameE("Gloria Tawny Porto")
                    .country("포르투갈")
                    .list("주정강화")
                    .price(49000)
                    .food("치즈,디저트")
                    .score(5)
                    .kind("틴타 로리즈, 투리가 프란카, 투리가 나시오날, 틴타 바로카, 틴토 까오")
                    .board(board)
                    .createDate(LocalDateTime.now())
                    .taste(tasteService.create(4, 4, 2, 3))
                    .build();
            this.wineRepository.save(w);
        }
    }
    @Test
    @DisplayName("와인 데이터 포르투갈 주정강화")
    void test39() throws Exception {
        String filePath1 = "/static/images/PJ 블랜디스 알바다 5년.jpg"; // 클래스패스 상의 경로
        // 파일 경로에서 InputStream 생성
        InputStream inputStream = getClass().getResourceAsStream(filePath1);
        byte[] content = inputStream.readAllBytes();
        MultipartFile multipartFile = new MockMultipartFile("file", "PJ 블랜디스 알바다 5년.jpg", "image/jpeg", content);
        List<Board> boards = boardService.addBoard(List.of(multipartFile));

        for (Board board : boards) {
            Wine w = Wine.builder()
                    .wineName("블랜디스 알바다 5년")
                    .wineNameE("Blandy's Alvada 5 Y.O Rich")
                    .country("포르투갈")
                    .list("주정강화")
                    .price(85000)
                    .food("치즈,디저트")
                    .score(5)
                    .kind("부알, 맘지")
                    .board(board)
                    .createDate(LocalDateTime.now())
                    .taste(tasteService.create(5, 5, 2, 2))
                    .build();
            this.wineRepository.save(w);
        }
    }
    @Test
    @DisplayName("와인 데이터 독일 레드")
    void test40() throws Exception {
        String filePath1 = "/static/images/GR 슈미트 숀, 돈펠더 라인헤센.jpg"; // 클래스패스 상의 경로
        // 파일 경로에서 InputStream 생성
        InputStream inputStream = getClass().getResourceAsStream(filePath1);
        byte[] content = inputStream.readAllBytes();
        MultipartFile multipartFile = new MockMultipartFile("file", "GR 슈미트 숀, 돈펠더 라인헤센.jpg", "image/jpeg", content);
        List<Board> boards = boardService.addBoard(List.of(multipartFile));

        for (Board board : boards) {
            Wine w = Wine.builder()
                    .wineName("슈미트 숀, 돈펠더 라인헤센")
                    .wineNameE("Schmitt Sohne, Dornfelder Rheinhessen")
                    .country("독일")
                    .list("레드")
                    .price(20000)
                    .food("소,돼지,닭")
                    .score(5)
                    .kind("돈펠더")
                    .board(board)
                    .createDate(LocalDateTime.now())
                    .taste(tasteService.create(3, 2, 4, 3))
                    .build();
            this.wineRepository.save(w);
        }
    }
    @Test
    @DisplayName("와인 데이터 독일 레드")
    void test41() throws Exception {
        String filePath1 = "/static/images/GR 아우구스트 케셀러, 피노누아.jpg"; // 클래스패스 상의 경로
        // 파일 경로에서 InputStream 생성
        InputStream inputStream = getClass().getResourceAsStream(filePath1);
        byte[] content = inputStream.readAllBytes();
        MultipartFile multipartFile = new MockMultipartFile("file", "GR 아우구스트 케셀러, 피노누아.jpg", "image/jpeg", content);
        List<Board> boards = boardService.addBoard(List.of(multipartFile));

        for (Board board : boards) {
            Wine w = Wine.builder()
                    .wineName("아우구스트 케셀러, 피노누아")
                    .wineNameE("August Kesseler, Pinot Noir")
                    .country("독일")
                    .list("레드")
                    .price(102000)
                    .food("생선회,치즈,소")
                    .score(3)
                    .kind("피노 누아 100%")
                    .board(board)
                    .createDate(LocalDateTime.now())
                    .taste(tasteService.create(1, 3, 5, 3))
                    .build();
            this.wineRepository.save(w);
        }
    }
    @Test
    @DisplayName("와인 데이터 독일 화이트")
    void test42() throws Exception {
        String filePath1 = "/static/images/GW 벨트악스 트로켄베렌아우스레제.jpg"; // 클래스패스 상의 경로
        // 파일 경로에서 InputStream 생성
        InputStream inputStream = getClass().getResourceAsStream(filePath1);
        byte[] content = inputStream.readAllBytes();
        MultipartFile multipartFile = new MockMultipartFile("file", "GW 벨트악스 트로켄베렌아우스레제.jpg", "image/jpeg", content);
        List<Board> boards = boardService.addBoard(List.of(multipartFile));

        for (Board board : boards) {
            Wine w = Wine.builder()
                    .wineName("벨트악스 트로켄베렌아우스레제")
                    .wineNameE("Weltachs Trockenbeerenauslese")
                    .country("독일")
                    .list("화이트")
                    .price(60000)
                    .food("과일,디저트")
                    .score(5)
                    .kind("오르테가, 알바롱가, 훅셀레베")
                    .board(board)
                    .createDate(LocalDateTime.now())
                    .taste(tasteService.create(5, 5, 3, 1))
                    .build();
            this.wineRepository.save(w);
        }
    }
    @Test
    @DisplayName("와인 데이터 독일 화이트")
    void test43() throws Exception {
        String filePath1 = "/static/images/GW 멜쉐이머, 리슬링 파인헤릅.png"; // 클래스패스 상의 경로
        // 파일 경로에서 InputStream 생성
        InputStream inputStream = getClass().getResourceAsStream(filePath1);
        byte[] content = inputStream.readAllBytes();
        MultipartFile multipartFile = new MockMultipartFile("file", "GW 멜쉐이머, 리슬링 파인헤릅.png", "image/png", content);
        List<Board> boards = boardService.addBoard(List.of(multipartFile));

        for (Board board : boards) {
            Wine w = Wine.builder()
                    .wineName("멜쉐이머, 리슬링 파인헤릅")
                    .wineNameE("Melsheimer, Riesling Feinherb")
                    .country("독일")
                    .list("화이트")
                    .price(68000)
                    .food("과일,해산물")
                    .score(4)
                    .kind("리슬링 100%")
                    .board(board)
                    .createDate(LocalDateTime.now())
                    .taste(tasteService.create(2, 3, 3, 1))
                    .build();
            this.wineRepository.save(w);
        }
    }
    @Test
    @DisplayName("와인 데이터 독일 스파클링")
    void test44() throws Exception {
        String filePath1 = "/static/images/GS된호프, 리슬링 브륏 나투르 젝트.png"; // 클래스패스 상의 경로
        // 파일 경로에서 InputStream 생성
        InputStream inputStream = getClass().getResourceAsStream(filePath1);
        byte[] content = inputStream.readAllBytes();
        MultipartFile multipartFile = new MockMultipartFile("file", "GS된호프, 리슬링 브륏 나투르 젝트.png", "image/png", content);
        List<Board> boards = boardService.addBoard(List.of(multipartFile));

        for (Board board : boards) {
            Wine w = Wine.builder()
                    .wineName("된호프, 리슬링 브륏 나투르 젝트")
                    .wineNameE("Dönnhoff, Riesling Brut Nature Sekt")
                    .country("독일")
                    .list("스파클링")
                    .price(180000)
                    .food("과일,해산물,돼지")
                    .score(4)
                    .kind("리슬링 100%")
                    .board(board)
                    .createDate(LocalDateTime.now())
                    .taste(tasteService.create(1, 2, 4, 1))
                    .build();
            this.wineRepository.save(w);
        }
    }
    @Test
    @DisplayName("와인 데이터 독일 스파클링")
    void test45() throws Exception {
        String filePath1 = "/static/images/GS 헨켈 트로켄 피콜로.jpg"; // 클래스패스 상의 경로
        // 파일 경로에서 InputStream 생성
        InputStream inputStream = getClass().getResourceAsStream(filePath1);
        byte[] content = inputStream.readAllBytes();
        MultipartFile multipartFile = new MockMultipartFile("file", "GS 헨켈 트로켄 피콜로.jpg", "image/jpeg", content);
        List<Board> boards = boardService.addBoard(List.of(multipartFile));

        for (Board board : boards) {
            Wine w = Wine.builder()
                    .wineName("헨켈 트로켄 피콜로")
                    .wineNameE("Henkell Trocken Piccolo")
                    .country("독일")
                    .list("스파클링")
                    .price(14000)
                    .food("해산물,생선회")
                    .score(4)
                    .kind("샤르도네, 소비뇽 블랑, 슈냉 블랑")
                    .board(board)
                    .createDate(LocalDateTime.now())
                    .taste(tasteService.create(1, 2, 4, 1))
                    .build();
            this.wineRepository.save(w);
        }
    }
    @Test
    @DisplayName("와인 데이터 독일 로제")
    void test46() throws Exception {
        String filePath1 = "/static/images/GRo 미쉘슈나이더 돈펠더 로제 아이스 와인.jpg"; // 클래스패스 상의 경로
        // 파일 경로에서 InputStream 생성
        InputStream inputStream = getClass().getResourceAsStream(filePath1);
        byte[] content = inputStream.readAllBytes();
        MultipartFile multipartFile = new MockMultipartFile("file", "GRo 미쉘슈나이더 돈펠더 로제 아이스 와인.jpg", "image/jpeg", content);
        List<Board> boards = boardService.addBoard(List.of(multipartFile));

        for (Board board : boards) {
            Wine w = Wine.builder()
                    .wineName("미쉘슈나이더 돈펠더 로제 아이스 와인")
                    .wineNameE("Michel Schneider Dornfelder Rose Eiswein")
                    .country("독일")
                    .list("로제")
                    .price(60000)
                    .food("해산물,생선회")
                    .score(5)
                    .kind("돈펠더 100%")
                    .board(board)
                    .createDate(LocalDateTime.now())
                    .taste(tasteService.create(5, 4, 2, 1))
                    .build();
            this.wineRepository.save(w);
        }
    }
    @Test
    @DisplayName("와인 데이터 독일 로제")
    void test47() throws Exception {
        String filePath1 = "/static/images/GRo 브리 피노 누아 로제.jpg"; // 클래스패스 상의 경로
        // 파일 경로에서 InputStream 생성
        InputStream inputStream = getClass().getResourceAsStream(filePath1);
        byte[] content = inputStream.readAllBytes();
        MultipartFile multipartFile = new MockMultipartFile("file", "GRo 브리 피노 누아 로제.jpg", "image/jpeg", content);
        List<Board> boards = boardService.addBoard(List.of(multipartFile));

        for (Board board : boards) {
            Wine w = Wine.builder()
                    .wineName("브리 피노 누아 로제")
                    .wineNameE("Bree Pinot Noir Rose")
                    .country("독일")
                    .list("로제")
                    .price(8800)
                    .food("해산물,디저트")
                    .score(5)
                    .kind("피노 누아 100%")
                    .board(board)
                    .createDate(LocalDateTime.now())
                    .taste(tasteService.create(4, 2, 2, 2))
                    .build();
            this.wineRepository.save(w);
        }
    }
    @Test
    @DisplayName("와인 데이터 미국 레드")
    void test48() throws Exception {
        String filePath1 = "/static/images/AR 갈로 리빙스톤 콩코드.jpg"; // 클래스패스 상의 경로
        // 파일 경로에서 InputStream 생성
        InputStream inputStream = getClass().getResourceAsStream(filePath1);
        byte[] content = inputStream.readAllBytes();
        MultipartFile multipartFile = new MockMultipartFile("file", "AR 갈로 리빙스톤 콩코드.jpg", "image/jpeg", content);
        List<Board> boards = boardService.addBoard(List.of(multipartFile));

        for (Board board : boards) {
            Wine w = Wine.builder()
                    .wineName("갈로 리빙스톤 콩코드")
                    .wineNameE("Gallo Livingston Concord")
                    .country("미국")
                    .list("레드")
                    .price(10500)
                    .food("해산물")
                    .score(3)
                    .kind("콩코드")
                    .board(board)
                    .createDate(LocalDateTime.now())
                    .taste(tasteService.create(1, 3, 4, 3))
                    .build();
            this.wineRepository.save(w);
        }
    }
    @Test
    @DisplayName("와인 데이터 미국 레드")
    void test49() throws Exception {
        String filePath1 = "/static/images/AR 더 프리즈너, 나파 밸리 레드 블렌드.jpg"; // 클래스패스 상의 경로
        // 파일 경로에서 InputStream 생성
        InputStream inputStream = getClass().getResourceAsStream(filePath1);
        byte[] content = inputStream.readAllBytes();
        MultipartFile multipartFile = new MockMultipartFile("file", "AR 더 프리즈너, 나파 밸리 레드 블렌드.jpg", "image/jpeg", content);
        List<Board> boards = boardService.addBoard(List.of(multipartFile));

        for (Board board : boards) {
            Wine w = Wine.builder()
                    .wineName("더 프리즈너, 나파 밸리 레드 블렌드")
                    .wineNameE("The Prisoner, Napa Valley Red Blend")
                    .country("미국")
                    .list("레드")
                    .price(146000)
                    .food("소")
                    .score(5)
                    .kind("진판델, 카베르네 소비뇽, 쁘띠 시라, 샤르보노")
                    .board(board)
                    .createDate(LocalDateTime.now())
                    .taste(tasteService.create(1, 5, 4, 5))
                    .build();
            this.wineRepository.save(w);
        }
    }
    @Test
    @DisplayName("와인 데이터 미국 화이트")
    void test50() throws Exception {
        String filePath1 = "/static/images/AW 메르 솔레이, 리저브 샤도네이.jpg"; // 클래스패스 상의 경로
        // 파일 경로에서 InputStream 생성
        InputStream inputStream = getClass().getResourceAsStream(filePath1);
        byte[] content = inputStream.readAllBytes();
        MultipartFile multipartFile = new MockMultipartFile("file", "AW 메르 솔레이, 리저브 샤도네이.jpg", "image/jpeg", content);
        List<Board> boards = boardService.addBoard(List.of(multipartFile));

        for (Board board : boards) {
            Wine w = Wine.builder()
                    .wineName("메르 솔레이, 리저브 샤도네이")
                    .wineNameE("Mer Soleil, Reserve Chardonnay")
                    .country("미국")
                    .list("화이트")
                    .price(89000)
                    .food("소,해산물")
                    .score(4)
                    .kind("샤르도네 100%")
                    .board(board)
                    .createDate(LocalDateTime.now())
                    .taste(tasteService.create(1, 4, 3, 1))
                    .build();
            this.wineRepository.save(w);
        }
    }
    @Test
    @DisplayName("와인 데이터 미국 화이트")
    void test51() throws Exception {
        String filePath1 = "/static/images/AW 샤논 릿지, 하이 엘레베이션 샤도네이.jpg"; // 클래스패스 상의 경로
        // 파일 경로에서 InputStream 생성
        InputStream inputStream = getClass().getResourceAsStream(filePath1);
        byte[] content = inputStream.readAllBytes();
        MultipartFile multipartFile = new MockMultipartFile("file", "AW 샤논 릿지, 하이 엘레베이션 샤도네이.jpg", "image/jpeg", content);
        List<Board> boards = boardService.addBoard(List.of(multipartFile));

        for (Board board : boards) {
            Wine w = Wine.builder()
                    .wineName("샤논 릿지, 하이 엘레베이션 샤도네이")
                    .wineNameE("Shannon Ridge, High Elevation Chardonnay")
                    .country("미국")
                    .list("화이트")
                    .price(84000)
                    .food("샐러드")
                    .score(4)
                    .kind("샤르도네 100%")
                    .board(board)
                    .createDate(LocalDateTime.now())
                    .taste(tasteService.create(1, 3, 4, 1))
                    .build();
            this.wineRepository.save(w);
        }
    }
    @Test
    @DisplayName("와인 데이터 미국 스파클링")
    void test52() throws Exception {
        String filePath1 = "/static/images/AS 도멘 생 미셸, 브뤼.png"; // 클래스패스 상의 경로
        // 파일 경로에서 InputStream 생성
        InputStream inputStream = getClass().getResourceAsStream(filePath1);
        byte[] content = inputStream.readAllBytes();
        MultipartFile multipartFile = new MockMultipartFile("file", "AS 도멘 생 미셸, 브뤼.png", "image/png", content);
        List<Board> boards = boardService.addBoard(List.of(multipartFile));

        for (Board board : boards) {
            Wine w = Wine.builder()
                    .wineName("도멘 생 미셸, 브뤼")
                    .wineNameE("Domaine Ste. Michelle, Brut")
                    .country("미국")
                    .list("스파클링")
                    .price(40000)
                    .food("돼지,해산물")
                    .score(4)
                    .kind("샤르도네, 피노 누아, 피노 뮈니에")
                    .board(board)
                    .createDate(LocalDateTime.now())
                    .taste(tasteService.create(2, 3, 3, 1))
                    .build();
            this.wineRepository.save(w);
        }
    }
    @Test
    @DisplayName("와인 데이터 미국 스파클링")
    void test53() throws Exception {
        String filePath1 = "/static/images/AS 필드 레코딩스, 드라이 홉 펫 낫.png"; // 클래스패스 상의 경로
        // 파일 경로에서 InputStream 생성
        InputStream inputStream = getClass().getResourceAsStream(filePath1);
        byte[] content = inputStream.readAllBytes();
        MultipartFile multipartFile = new MockMultipartFile("file", "AS 필드 레코딩스, 드라이 홉 펫 낫.png", "image/png", content);
        List<Board> boards = boardService.addBoard(List.of(multipartFile));

        for (Board board : boards) {
            Wine w = Wine.builder()
                    .wineName("필드 레코딩스, 드라이 홉 펫 낫")
                    .wineNameE("Field Recordings, Dry Hop Pet Nat")
                    .country("미국")
                    .list("스파클링")
                    .price(99000)
                    .food("디저트,해산물")
                    .score(2)
                    .kind("샤르도네")
                    .board(board)
                    .createDate(LocalDateTime.now())
                    .taste(tasteService.create(2, 2, 3, 1))
                    .build();
            this.wineRepository.save(w);
        }
    }
    @Test
    @DisplayName("와인 데이터 미국 로제")
    void test54() throws Exception {
        String filePath1 = "/static/images/ARo 퓨리티, 스트로베리 데이즈 지에스엠.png"; // 클래스패스 상의 경로
        // 파일 경로에서 InputStream 생성
        InputStream inputStream = getClass().getResourceAsStream(filePath1);
        byte[] content = inputStream.readAllBytes();
        MultipartFile multipartFile = new MockMultipartFile("file", "ARo 퓨리티, 스트로베리 데이즈 지에스엠.png", "image/png", content);
        List<Board> boards = boardService.addBoard(List.of(multipartFile));

        for (Board board : boards) {
            Wine w = Wine.builder()
                    .wineName("퓨리티, 스트로베리 데이즈 지에스엠")
                    .wineNameE("Purity, Strawberry Daze GSM")
                    .country("미국")
                    .list("로제")
                    .price(130000)
                    .food("돼지,닭,해산물,치즈")
                    .score(2)
                    .kind("그르나슈, 무르베드르, 시라/쉬라즈")
                    .board(board)
                    .createDate(LocalDateTime.now())
                    .taste(tasteService.create(1, 2, 4, 1))
                    .build();
            this.wineRepository.save(w);
        }
    }
    @Test
    @DisplayName("와인 데이터 미국 로제")
    void test55() throws Exception {
        String filePath1 = "/static/images/ARo 마리오니, 아우레오 로제 소노마 마운틴.png"; // 클래스패스 상의 경로
        // 파일 경로에서 InputStream 생성
        InputStream inputStream = getClass().getResourceAsStream(filePath1);
        byte[] content = inputStream.readAllBytes();
        MultipartFile multipartFile = new MockMultipartFile("file", "ARo 마리오니, 아우레오 로제 소노마 마운틴.png", "image/png", content);
        List<Board> boards = boardService.addBoard(List.of(multipartFile));

        for (Board board : boards) {
            Wine w = Wine.builder()
                    .wineName("마리오니, 아우레오 로제 소노마 마운틴")
                    .wineNameE("Marioni, Aureo Rose Sonoma Mountain")
                    .country("미국")
                    .list("로제")
                    .price(120000)
                    .food("샐러드,치즈")
                    .score(3)
                    .kind("메를로, 샤르도네")
                    .board(board)
                    .createDate(LocalDateTime.now())
                    .taste(tasteService.create(1, 3, 4, 1))
                    .build();
            this.wineRepository.save(w);
        }
    }
    @Test
    @DisplayName("와인 데이터 미국 주정강화")
    void test56() throws Exception {
        String filePath1 = "/static/images/AJ 쉐필드 타우니 포트.jpg"; // 클래스패스 상의 경로
        // 파일 경로에서 InputStream 생성
        InputStream inputStream = getClass().getResourceAsStream(filePath1);
        byte[] content = inputStream.readAllBytes();
        MultipartFile multipartFile = new MockMultipartFile("file", "AJ 쉐필드 타우니 포트.jpg", "image/jpeg", content);
        List<Board> boards = boardService.addBoard(List.of(multipartFile));

        for (Board board : boards) {
            Wine w = Wine.builder()
                    .wineName("쉐필드 타우니 포트")
                    .wineNameE("Sheffield Tawny port")
                    .country("미국")
                    .list("주정강화")
                    .price(0)
                    .food("디저트,치즈")
                    .score(4)
                    .kind("블렌드")
                    .board(board)
                    .createDate(LocalDateTime.now())
                    .taste(tasteService.create(5, 5, 2, 3))
                    .build();
            this.wineRepository.save(w);
        }
    }
    @Test
    @DisplayName("와인 데이터 호주 레드")
    void test57() throws Exception {
        String filePath1 = "/static/images/AUR 헨쉬키, 힐 오브 그레이스.jpg"; // 클래스패스 상의 경로
        // 파일 경로에서 InputStream 생성
        InputStream inputStream = getClass().getResourceAsStream(filePath1);
        byte[] content = inputStream.readAllBytes();
        MultipartFile multipartFile = new MockMultipartFile("file", "AUR 헨쉬키, 힐 오브 그레이스.jpg", "image/jpeg", content);
        List<Board> boards = boardService.addBoard(List.of(multipartFile));

        for (Board board : boards) {
            Wine w = Wine.builder()
                    .wineName("헨쉬키, 힐 오브 그레이스")
                    .wineNameE("Henschke, Hill of Grace")
                    .country("호주")
                    .list("레드")
                    .price(1755000)
                    .food("소,치즈,과일")
                    .score(5)
                    .kind("시라/쉬라즈 100%")
                    .board(board)
                    .createDate(LocalDateTime.now())
                    .taste(tasteService.create(1, 5, 4, 5))
                    .build();
            this.wineRepository.save(w);
        }
    }
    @Test
    @DisplayName("와인 데이터 호주 레드")
    void test58() throws Exception {
        String filePath1 = "/static/images/AUR 펜폴즈, 그랜지.png"; // 클래스패스 상의 경로
        // 파일 경로에서 InputStream 생성
        InputStream inputStream = getClass().getResourceAsStream(filePath1);
        byte[] content = inputStream.readAllBytes();
        MultipartFile multipartFile = new MockMultipartFile("file", "AUR 펜폴즈, 그랜지.png", "image/png", content);
        List<Board> boards = boardService.addBoard(List.of(multipartFile));

        for (Board board : boards) {
            Wine w = Wine.builder()
                    .wineName("펜폴즈, 그랜지")
                    .wineNameE("Penfolds, Grange")
                    .country("호주")
                    .list("레드")
                    .price(1500000)
                    .food("샐러드,치즈")
                    .score(5)
                    .kind("시라/쉬라즈 98%, 카베르네 소비뇽 2%")
                    .board(board)
                    .createDate(LocalDateTime.now())
                    .taste(tasteService.create(1, 5, 4, 5))
                    .build();
            this.wineRepository.save(w);
        }
    }
    @Test
    @DisplayName("와인 데이터 호주 화이트")
    void test59() throws Exception {
        String filePath1 = "/static/images/AUW 가트, 리슬링.jpg"; // 클래스패스 상의 경로
        // 파일 경로에서 InputStream 생성
        InputStream inputStream = getClass().getResourceAsStream(filePath1);
        byte[] content = inputStream.readAllBytes();
        MultipartFile multipartFile = new MockMultipartFile("file", "AUW 가트, 리슬링.jpg", "image/jpeg", content);
        List<Board> boards = boardService.addBoard(List.of(multipartFile));

        for (Board board : boards) {
            Wine w = Wine.builder()
                    .wineName("가트, 리슬링")
                    .wineNameE("Gatt, Riesling")
                    .country("호주")
                    .list("화이트")
                    .price(110000)
                    .food("샐러드,치즈,해산물")
                    .score(4)
                    .kind("리슬링 100%")
                    .board(board)
                    .createDate(LocalDateTime.now())
                    .taste(tasteService.create(2, 3, 4, 1))
                    .build();
            this.wineRepository.save(w);
        }
    }
    @Test
    @DisplayName("와인 데이터 호주 화이트")
    void test60() throws Exception {
        String filePath1 = "/static/images/AUW 펜폴즈, 야타나 샤도네이.png"; // 클래스패스 상의 경로
        // 파일 경로에서 InputStream 생성
        InputStream inputStream = getClass().getResourceAsStream(filePath1);
        byte[] content = inputStream.readAllBytes();
        MultipartFile multipartFile = new MockMultipartFile("file", "AUW 펜폴즈, 야타나 샤도네이.png", "image/png", content);
        List<Board> boards = boardService.addBoard(List.of(multipartFile));

        for (Board board : boards) {
            Wine w = Wine.builder()
                    .wineName("펜폴즈, 야타나 샤도네이")
                    .wineNameE("Penfolds, Yattarna Chardonnay")
                    .country("호주")
                    .list("화이트")
                    .price(550000)
                    .food("해산물")
                    .score(4)
                    .kind("샤르도네 100%")
                    .board(board)
                    .createDate(LocalDateTime.now())
                    .taste(tasteService.create(1, 4, 4, 1))
                    .build();
            this.wineRepository.save(w);
        }
    }
    @Test
    @DisplayName("와인 데이터 호주 스파클링")
    void test61() throws Exception {
        String filePath1 = "/static/images/AUS 글리터 어스.png"; // 클래스패스 상의 경로
        // 파일 경로에서 InputStream 생성
        InputStream inputStream = getClass().getResourceAsStream(filePath1);
        byte[] content = inputStream.readAllBytes();
        MultipartFile multipartFile = new MockMultipartFile("file", "AUS 글리터 어스.png", "image/png", content);
        List<Board> boards = boardService.addBoard(List.of(multipartFile));

        for (Board board : boards) {
            Wine w = Wine.builder()
                    .wineName("글리터 어스")
                    .wineNameE("Glitter Us")
                    .country("호주")
                    .list("스파클링")
                    .price(120000)
                    .food("해산물,과일,치즈,샐러드,디저트")
                    .score(3)
                    .kind("베르멘티노, 리슬링")
                    .board(board)
                    .createDate(LocalDateTime.now())
                    .taste(tasteService.create(1, 2, 4, 2))
                    .build();
            this.wineRepository.save(w);
        }
    }
    @Test
    @DisplayName("와인 데이터 호주 스파클링")
    void test62() throws Exception {
        String filePath1 = "/static/images/AUS 낫 데디.png"; // 클래스패스 상의 경로
        // 파일 경로에서 InputStream 생성
        InputStream inputStream = getClass().getResourceAsStream(filePath1);
        byte[] content = inputStream.readAllBytes();
        MultipartFile multipartFile = new MockMultipartFile("file", "AUS 낫 데디.png", "image/png", content);
        List<Board> boards = boardService.addBoard(List.of(multipartFile));

        for (Board board : boards) {
            Wine w = Wine.builder()
                    .wineName("낫 데디")
                    .wineNameE("Nat Daddy")
                    .country("호주")
                    .list("스파클링")
                    .price(120000)
                    .food("해산물,과일,치즈,샐러드,디저트")
                    .score(3)
                    .kind("소비뇽 블랑, 시라/쉬라즈")
                    .board(board)
                    .createDate(LocalDateTime.now())
                    .taste(tasteService.create(1, 2, 3, 2))
                    .build();
            this.wineRepository.save(w);
        }
    }
    @Test
    @DisplayName("와인 데이터 호주 로제")
    void test63() throws Exception {
        String filePath1 = "/static/images/AURo 그랜트 버지, 모스카토 로사.jpg"; // 클래스패스 상의 경로
        // 파일 경로에서 InputStream 생성
        InputStream inputStream = getClass().getResourceAsStream(filePath1);
        byte[] content = inputStream.readAllBytes();
        MultipartFile multipartFile = new MockMultipartFile("file", "AURo 그랜트 버지, 모스카토 로사.jpg", "image/jpeg", content);
        List<Board> boards = boardService.addBoard(List.of(multipartFile));

        for (Board board : boards) {
            Wine w = Wine.builder()
                    .wineName("그랜트 버지, 모스카토 로사")
                    .wineNameE("Grant Burge, Moscato Rosa")
                    .country("호주")
                    .list("로제")
                    .price(45000)
                    .food("치즈")
                    .score(3)
                    .kind("모스카토 로사")
                    .board(board)
                    .createDate(LocalDateTime.now())
                    .taste(tasteService.create(4, 2, 2, 1))
                    .build();
            this.wineRepository.save(w);
        }
    }
    @Test
    @DisplayName("와인 데이터 호주 로제")
    void test64() throws Exception {
        String filePath1 = "/static/images/AURo 제이콥스 크릭, 르 쁘띠 로제.png"; // 클래스패스 상의 경로
        // 파일 경로에서 InputStream 생성
        InputStream inputStream = getClass().getResourceAsStream(filePath1);
        byte[] content = inputStream.readAllBytes();
        MultipartFile multipartFile = new MockMultipartFile("file", "AURo 제이콥스 크릭, 르 쁘띠 로제.png", "image/png", content);
        List<Board> boards = boardService.addBoard(List.of(multipartFile));

        for (Board board : boards) {
            Wine w = Wine.builder()
                    .wineName("제이콥스 크릭, 르 쁘띠 로제")
                    .wineNameE("Jacob's Creek, Le Petit Rose")
                    .country("호주")
                    .list("로제")
                    .price(35000)
                    .food("해산물,샐러드")
                    .score(4)
                    .kind("그르나슈 , 피노 누아 , 모나스트렐")
                    .board(board)
                    .createDate(LocalDateTime.now())
                    .taste(tasteService.create(2, 3, 2, 2))
                    .build();
            this.wineRepository.save(w);
        }
    }
    @Test
    @DisplayName("와인 데이터 호주 주정강화")
    void test65() throws Exception {
        String filePath1 = "/static/images/AUJ 하셀그로브, 디 올드넛 토니 포트.jpg"; // 클래스패스 상의 경로
        // 파일 경로에서 InputStream 생성
        InputStream inputStream = getClass().getResourceAsStream(filePath1);
        byte[] content = inputStream.readAllBytes();
        MultipartFile multipartFile = new MockMultipartFile("file", "AUJ 하셀그로브, 디 올드넛 토니 포트.jpg", "image/jpeg", content);
        List<Board> boards = boardService.addBoard(List.of(multipartFile));

        for (Board board : boards) {
            Wine w = Wine.builder()
                    .wineName("하셀그로브, 디 올드넛 토니 포트")
                    .wineNameE("Haselgrove, The Old Nut Tawny Port")
                    .country("호주")
                    .list("주정강화")
                    .price(101000)
                    .food("디저트")
                    .score(5)
                    .kind("시라/쉬라즈 , 그르나슈 , 샤르도네")
                    .board(board)
                    .createDate(LocalDateTime.now())
                    .taste(tasteService.create(5, 2, 5, 2))
                    .build();
            this.wineRepository.save(w);
        }
    }
    @Test
    @DisplayName("와인 데이터 호주 주정강화")
    void test66() throws Exception {
        String filePath1 = "/static/images/AUJ 앙고브, 그랜드 토니 10년.png"; // 클래스패스 상의 경로
        // 파일 경로에서 InputStream 생성
        InputStream inputStream = getClass().getResourceAsStream(filePath1);
        byte[] content = inputStream.readAllBytes();
        MultipartFile multipartFile = new MockMultipartFile("file", "AUJ 앙고브, 그랜드 토니 10년.png", "image/png", content);
        List<Board> boards = boardService.addBoard(List.of(multipartFile));

        for (Board board : boards) {
            Wine w = Wine.builder()
                    .wineName("앙고브, 그랜드 토니 10년")
                    .wineNameE("Angove, Grand Tawny 10years")
                    .country("호주")
                    .list("주정강화")
                    .price(75000)
                    .food("디저트,치즈")
                    .score(5)
                    .kind("블렌드")
                    .board(board)
                    .createDate(LocalDateTime.now())
                    .taste(tasteService.create(5, 2, 5, 2))
                    .build();
            this.wineRepository.save(w);
        }
    }

    @Test
    @DisplayName("와인 데이터 칠레 레드")
    void test67() throws Exception {
        String filePath1 = "/static/images/CR 7 컬러즈, '그랑 리제르바' 카베르네 소비뇽 뮈스카.png"; // 클래스패스 상의 경로
        // 파일 경로에서 InputStream 생성
        InputStream inputStream = getClass().getResourceAsStream(filePath1);
        byte[] content = inputStream.readAllBytes();
        MultipartFile multipartFile = new MockMultipartFile("file", "CR 7 컬러즈, '그랑 리제르바' 카베르네 소비뇽 뮈스카.png", "image/png", content);
        List<Board> boards = boardService.addBoard(List.of(multipartFile));

        for (Board board : boards) {
            Wine w = Wine.builder()
                    .wineName("7 컬러즈, '그랑 리제르바' 카베르네 소비뇽 뮈스카")
                    .wineNameE("7 Colores, 'Gran Rseserva' Cabernet Sauvignon Muscat")
                    .country("칠레")
                    .list("레드")
                    .price(36000)
                    .food("소")
                    .score(4)
                    .kind("카베르네 소비뇽 , 뮈스까")
                    .board(board)
                    .createDate(LocalDateTime.now())
                    .taste(tasteService.create(1, 3, 3, 3))
                    .build();
            this.wineRepository.save(w);
        }
    }
    @Test
    @DisplayName("와인 데이터 칠레 레드")
    void test68() throws Exception {
        String filePath1 = "/static/images/CR 미션 드 렝고, 뀌베 카베르네 소비뇽.jpg"; // 클래스패스 상의 경로
        // 파일 경로에서 InputStream 생성
        InputStream inputStream = getClass().getResourceAsStream(filePath1);
        byte[] content = inputStream.readAllBytes();
        MultipartFile multipartFile = new MockMultipartFile("file", "CR 미션 드 렝고, 뀌베 카베르네 소비뇽.jpg", "image/jpeg", content);
        List<Board> boards = boardService.addBoard(List.of(multipartFile));

        for (Board board : boards) {
            Wine w = Wine.builder()
                    .wineName("미션 드 렝고, 뀌베 카베르네 소비뇽")
                    .wineNameE("Misiones de Rengo, Cuvee Cabernet Sauvignon")
                    .country("칠레")
                    .list("레드")
                    .price(55000)
                    .food("소,닭,해산물,치즈")
                    .score(5)
                    .kind("카베르네 소비뇽 , 시라/쉬라즈 , 카르메네르")
                    .board(board)
                    .createDate(LocalDateTime.now())
                    .taste(tasteService.create(1, 3, 4, 4))
                    .build();
            this.wineRepository.save(w);
        }
    }
    @Test
    @DisplayName("와인 데이터 칠레 화이트")
    void test69() throws Exception {
        String filePath1 = "/static/images/CW 루이스 펠리페 에드워즈 시그니처 샤도네이.jpg"; // 클래스패스 상의 경로
        // 파일 경로에서 InputStream 생성
        InputStream inputStream = getClass().getResourceAsStream(filePath1);
        byte[] content = inputStream.readAllBytes();
        MultipartFile multipartFile = new MockMultipartFile("file", "CW 루이스 펠리페 에드워즈 시그니처 샤도네이.jpg", "image/jpeg", content);
        List<Board> boards = boardService.addBoard(List.of(multipartFile));

        for (Board board : boards) {
            Wine w = Wine.builder()
                    .wineName("루이스 펠리페 에드워즈 시그니처 샤도네이")
                    .wineNameE("Luis Felipe Edwards Signature Series Chardonnay")
                    .country("칠레")
                    .list("화이트")
                    .price(25000)
                    .food("샐러드,해산물")
                    .score(3)
                    .kind("샤르도네")
                    .board(board)
                    .createDate(LocalDateTime.now())
                    .taste(tasteService.create(1, 3, 3, 1))
                    .build();
            this.wineRepository.save(w);
        }
    }
    @Test
    @DisplayName("와인 데이터 칠레 화이트")
    void test70() throws Exception {
        String filePath1 = "/static/images/CW 콘차이 토로, 디아블로 소비뇽 블랑.jpg"; // 클래스패스 상의 경로
        // 파일 경로에서 InputStream 생성
        InputStream inputStream = getClass().getResourceAsStream(filePath1);
        byte[] content = inputStream.readAllBytes();
        MultipartFile multipartFile = new MockMultipartFile("file", "CW 콘차이 토로, 디아블로 소비뇽 블랑.jpg", "image/jpeg", content);
        List<Board> boards = boardService.addBoard(List.of(multipartFile));

        for (Board board : boards) {
            Wine w = Wine.builder()
                    .wineName("콘차이 토로, 디아블로 소비뇽 블랑")
                    .wineNameE("Concha y Toro, Casillero del Diablo Sauvignon Blanc")
                    .country("칠레")
                    .list("화이트")
                    .price(12800)
                    .food("샐러드,해산물,닭")
                    .score(3)
                    .kind("소비뇽 블랑")
                    .board(board)
                    .createDate(LocalDateTime.now())
                    .taste(tasteService.create(1, 4, 2, 1))
                    .build();
            this.wineRepository.save(w);
        }
    }
    @Test
    @DisplayName("와인 데이터 칠레 스파클링")
    void test71() throws Exception {
        String filePath1 = "/static/images/CS 7 컬러즈, 브륏 샤르마.png"; // 클래스패스 상의 경로
        // 파일 경로에서 InputStream 생성
        InputStream inputStream = getClass().getResourceAsStream(filePath1);
        byte[] content = inputStream.readAllBytes();
        MultipartFile multipartFile = new MockMultipartFile("file", "CS 7 컬러즈, 브륏 샤르마.png", "image/png", content);
        List<Board> boards = boardService.addBoard(List.of(multipartFile));

        for (Board board : boards) {
            Wine w = Wine.builder()
                    .wineName("7 컬러즈, 브륏 샤르마")
                    .wineNameE("7 Colores, Brut Charmat")
                    .country("칠레")
                    .list("스파클링")
                    .price(36000)
                    .food("돼지,치즈")
                    .score(2)
                    .kind("샤르도네")
                    .board(board)
                    .createDate(LocalDateTime.now())
                    .taste(tasteService.create(1, 4, 1, 1))
                    .build();
            this.wineRepository.save(w);
        }
    }
    @Test
    @DisplayName("와인 데이터 칠레 스파클링")
    void test72() throws Exception {
        String filePath1 = "/static/images/CS  코노 수르, 센티넬라 브뤼.jpg"; // 클래스패스 상의 경로
        // 파일 경로에서 InputStream 생성
        InputStream inputStream = getClass().getResourceAsStream(filePath1);
        byte[] content = inputStream.readAllBytes();
        MultipartFile multipartFile = new MockMultipartFile("file", "CS  코노 수르, 센티넬라 브뤼.jpg", "image/jpeg", content);
        List<Board> boards = boardService.addBoard(List.of(multipartFile));

        for (Board board : boards) {
            Wine w = Wine.builder()
                    .wineName("코노 수르, 센티넬라 브뤼")
                    .wineNameE("Cono Sur, Centinela Brut")
                    .country("칠레")
                    .list("스파클링")
                    .price(28000)
                    .food("일식,해산물")
                    .score(4)
                    .kind("샤르도네")
                    .board(board)
                    .createDate(LocalDateTime.now())
                    .taste(tasteService.create(1, 4, 3, 1))
                    .build();
            this.wineRepository.save(w);
        }
    }
    @Test
    @DisplayName("와인 데이터 칠레 로제")
    void test73() throws Exception {
        String filePath1 = "/static/images/CRo 모란데, 피오네로 로제.jpg"; // 클래스패스 상의 경로
        // 파일 경로에서 InputStream 생성
        InputStream inputStream = getClass().getResourceAsStream(filePath1);
        byte[] content = inputStream.readAllBytes();
        MultipartFile multipartFile = new MockMultipartFile("file", "CRo 모란데, 피오네로 로제.jpg", "image/jpeg", content);
        List<Board> boards = boardService.addBoard(List.of(multipartFile));

        for (Board board : boards) {
            Wine w = Wine.builder()
                    .wineName("모란데, 피오네로 로제")
                    .wineNameE("Morande, Pionero Rose")
                    .country("칠레")
                    .list("로제")
                    .price(25000)
                    .food("디저트,돼지,소")
                    .score(3)
                    .kind("카베르네 소비뇽 , 시라/쉬라즈")
                    .board(board)
                    .createDate(LocalDateTime.now())
                    .taste(tasteService.create(2, 3, 3, 1))
                    .build();
            this.wineRepository.save(w);
        }
    }
    @Test
    @DisplayName("와인 데이터 칠레 로제")
    void test74() throws Exception {
        String filePath1 = "/static/images/CRo 몬테스, 슈럽.png"; // 클래스패스 상의 경로
        // 파일 경로에서 InputStream 생성
        InputStream inputStream = getClass().getResourceAsStream(filePath1);
        byte[] content = inputStream.readAllBytes();
        MultipartFile multipartFile = new MockMultipartFile("file", "CRo 몬테스, 슈럽.png", "image/png", content);
        List<Board> boards = boardService.addBoard(List.of(multipartFile));

        for (Board board : boards) {
            Wine w = Wine.builder()
                    .wineName("몬테스, 슈럽")
                    .wineNameE("Montes, Cherub")
                    .country("칠레")
                    .list("로제")
                    .price(37000)
                    .food("해산물")
                    .score(2)
                    .kind("시라/쉬라즈 , 그르나슈")
                    .board(board)
                    .createDate(LocalDateTime.now())
                    .taste(tasteService.create(1, 3, 2, 1))
                    .build();
            this.wineRepository.save(w);
        }
    }
    @Test
    @DisplayName("와인 데이터 아르헨티나 레드")
    void test75() throws Exception {
        String filePath1 = "/static/images/ArR 카네타 자파타, 안젤리카 자파타 말벡.png"; // 클래스패스 상의 경로
        // 파일 경로에서 InputStream 생성
        InputStream inputStream = getClass().getResourceAsStream(filePath1);
        byte[] content = inputStream.readAllBytes();
        MultipartFile multipartFile = new MockMultipartFile("file", "ArR 카네타 자파타, 안젤리카 자파타 말벡.png", "image/png", content);
        List<Board> boards = boardService.addBoard(List.of(multipartFile));

        for (Board board : boards) {
            Wine w = Wine.builder()
                    .wineName("카네타 자파타, 안젤리카 자파타 말벡")
                    .wineNameE("Catena Zapata, Angelica Zapata Malbec")
                    .country("아르헨티나")
                    .list("레드")
                    .price(88700)
                    .food("소,양,치즈")
                    .score(5)
                    .kind("말벡")
                    .board(board)
                    .createDate(LocalDateTime.now())
                    .taste(tasteService.create(1, 4, 4, 5))
                    .build();
            this.wineRepository.save(w);
        }
    }
    @Test
    @DisplayName("와인 데이터 아르헨티나 레드")
    void test76() throws Exception {
        String filePath1 = "/static/images/ArR 트라피체, 이스까이 시라 비오니에.jpg"; // 클래스패스 상의 경로
        // 파일 경로에서 InputStream 생성
        InputStream inputStream = getClass().getResourceAsStream(filePath1);
        byte[] content = inputStream.readAllBytes();
        MultipartFile multipartFile = new MockMultipartFile("file", "ArR 트라피체, 이스까이 시라 비오니에.jpg", "image/jpeg", content);
        List<Board> boards = boardService.addBoard(List.of(multipartFile));

        for (Board board : boards) {
            Wine w = Wine.builder()
                    .wineName("트라피체, 이스까이 시라 비오니에")
                    .wineNameE("Trapiche, Iscay Syrah Viognier")
                    .country("아르헨티나")
                    .list("레드")
                    .price(140000)
                    .food("치즈")
                    .score(5)
                    .kind("시라/쉬라즈 , 비오니에")
                    .board(board)
                    .createDate(LocalDateTime.now())
                    .taste(tasteService.create(1, 3, 5, 4))
                    .build();
            this.wineRepository.save(w);
        }
    }
    @Test
    @DisplayName("와인 데이터 아르헨티나 화이트")
    void test77() throws Exception {
        String filePath1 = "/static/images/ArW 카테나 자파타, 안젤리카 자파타 샤도네이.png"; // 클래스패스 상의 경로
        // 파일 경로에서 InputStream 생성
        InputStream inputStream = getClass().getResourceAsStream(filePath1);
        byte[] content = inputStream.readAllBytes();
        MultipartFile multipartFile = new MockMultipartFile("file", "ArW 카테나 자파타, 안젤리카 자파타 샤도네이.png", "image/png", content);
        List<Board> boards = boardService.addBoard(List.of(multipartFile));

        for (Board board : boards) {
            Wine w = Wine.builder()
                    .wineName("카테나 자파타, 안젤리카 자파타 샤도네이")
                    .wineNameE("Catena Zapata, Angelica Zapata Chardonnay")
                    .country("아르헨티나")
                    .list("화이트")
                    .price(83300)
                    .food("닭,해산물,샐러드")
                    .score(3)
                    .kind("샤르도네")
                    .board(board)
                    .createDate(LocalDateTime.now())
                    .taste(tasteService.create(1, 3, 1, 1))
                    .build();
            this.wineRepository.save(w);
        }
    }
    @Test
    @DisplayName("와인 데이터 아르헨티나 화이트")
    void test78() throws Exception {
        String filePath1 = "/static/images/ArW 로렌조 데 아그렐로, 마르티르 샤도네이.png"; // 클래스패스 상의 경로
        // 파일 경로에서 InputStream 생성
        InputStream inputStream = getClass().getResourceAsStream(filePath1);
        byte[] content = inputStream.readAllBytes();
        MultipartFile multipartFile = new MockMultipartFile("file", "ArW 로렌조 데 아그렐로, 마르티르 샤도네이.png", "image/png", content);
        List<Board> boards = boardService.addBoard(List.of(multipartFile));

        for (Board board : boards) {
            Wine w = Wine.builder()
                    .wineName("로렌조 데 아그렐로, 마르티르 샤도네이")
                    .wineNameE("Lorenzo de Agrelo, Martir Chardonnay")
                    .country("아르헨티나")
                    .list("화이트")
                    .price(95000)
                    .food("치즈,샐러드")
                    .score(3)
                    .kind("샤르도네")
                    .board(board)
                    .createDate(LocalDateTime.now())
                    .taste(tasteService.create(1, 3, 1, 1))
                    .build();
            this.wineRepository.save(w);
        }
    }
    @Test
    @DisplayName("와인 데이터 아르헨티나 스파클링")
    void test79() throws Exception {
        String filePath1 = "/static/images/ArS 알타 비스타, 비베 스위트 스파클링.png"; // 클래스패스 상의 경로
        // 파일 경로에서 InputStream 생성
        InputStream inputStream = getClass().getResourceAsStream(filePath1);
        byte[] content = inputStream.readAllBytes();
        MultipartFile multipartFile = new MockMultipartFile("file", "ArS 알타 비스타, 비베 스위트 스파클링.png", "image/png", content);
        List<Board> boards = boardService.addBoard(List.of(multipartFile));

        for (Board board : boards) {
            Wine w = Wine.builder()
                    .wineName("알타 비스타, 비베 스위트 스파클링")
                    .wineNameE("Alta Vista, Vive Sweet Sparkling")
                    .country("아르헨티나")
                    .list("스파클링")
                    .price(30000)
                    .food("치즈,과일,디저트")
                    .score(4)
                    .kind("토론테스")
                    .board(board)
                    .createDate(LocalDateTime.now())
                    .taste(tasteService.create(2, 4, 1, 1))
                    .build();
            this.wineRepository.save(w);
        }
    }
    @Test
    @DisplayName("와인 데이터 아르헨티나 스파클링")
    void test80() throws Exception {
        String filePath1 = "/static/images/ArS 나바로 꼬레아스, 엑스트라 브뤼.jpg"; // 클래스패스 상의 경로
        // 파일 경로에서 InputStream 생성
        InputStream inputStream = getClass().getResourceAsStream(filePath1);
        byte[] content = inputStream.readAllBytes();
        MultipartFile multipartFile = new MockMultipartFile("file", "ArS 나바로 꼬레아스, 엑스트라 브뤼.jpg", "image/jpeg", content);
        List<Board> boards = boardService.addBoard(List.of(multipartFile));

        for (Board board : boards) {
            Wine w = Wine.builder()
                    .wineName("나바로 꼬레아스, 엑스트라 브뤼")
                    .wineNameE("Navarro Correas, Extra Brut")
                    .country("아르헨티나")
                    .list("스파클링")
                    .price(64000)
                    .food("디저트")
                    .score(4)
                    .kind("샤르도네 , 피노 누아")
                    .board(board)
                    .createDate(LocalDateTime.now())
                    .taste(tasteService.create(1, 4, 2, 1))
                    .build();
            this.wineRepository.save(w);
        }
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

