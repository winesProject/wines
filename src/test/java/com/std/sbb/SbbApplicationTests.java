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
        String filePath = "/static/images/AJ 쉐필드 타우니 포트.jpg"; // 클래스패스 상의 경로

        // 파일 경로에서 InputStream 생성
        InputStream inputStream = getClass().getResourceAsStream(filePath);
        byte[] content = inputStream.readAllBytes();
        MultipartFile multipartFile = new MockMultipartFile("file", "AJ 쉐필드 타우니 포트.jpg", "image/jpg", content);

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
                    .taste(tasteService.create(1, 3, 3, 4))
                    .build();
            this.wineRepository.save(w);
        }
    }
    @Test
    @DisplayName("와인 데이터")
    void test02() throws Exception {
        String filePath = "/static/images/FR 베리 브라더스 & 러드, 프로방스 로제.jpg"; // 클래스패스 상의 경로

        // 파일 경로에서 InputStream 생성
        InputStream inputStream = getClass().getResourceAsStream(filePath);
        byte[] content = inputStream.readAllBytes();
        MultipartFile multipartFile = new MockMultipartFile("file", "FR 베리 브라더스 & 러드, 프로방스 로제.jpg", "image/jpg", content);

        List<Board> boards = boardService.addBoard(List.of(multipartFile));

        for (Board board : boards) {
            Wine w = Wine.builder()
                    .wineName("기욤 르탕, 루비 루즈")
                    .wineNameE("Guillaume Letang, Rubis Rouge")
                    .country("프랑스")
                    .list("레드")
                    .price(0)
                    .food("소고기, 스테이크, 불고기, 양꼬치, 족발, 한국음식, 피자, 햄버거")
                    .score(2)
                    .kind("그르나슈")
                    .board(board)
                    .createDate(LocalDateTime.now())
                    .taste(tasteService.create(1, 3, 3, 3))
                    .build();
            this.wineRepository.save(w);
        }
    }
    @Test
    @DisplayName("와인 데이터")
    void test03() throws Exception {
        String filePath = "/static/images/AUJ 앙고브, 그랜드 토니 10년.png"; // 클래스패스 상의 경로

        // 파일 경로에서 InputStream 생성
        InputStream inputStream = getClass().getResourceAsStream(filePath);
        byte[] content = inputStream.readAllBytes();
        MultipartFile multipartFile = new MockMultipartFile("file", "AUJ 앙고브, 그랜드 토니 10년.png", "image/png", content);

        List<Board> boards = boardService.addBoard(List.of(multipartFile));

        for (Board board : boards) {
            Wine w = Wine.builder()
                    .wineName("도멘 마샹 프레르, 샹볼 뮈지니 프리미에르 크뤼 레 성띠에")
                    .wineNameE("Domaine Marchand Freres, Chambolle-Musigny 1er Cru Les Sentiers")
                    .country("프랑스")
                    .list("레드")
                    .price(0)
                    .food("치즈")
                    .score(5)
                    .kind("피노 누아 100%")
                    .board(board)
                    .createDate(LocalDateTime.now())
                    .taste(tasteService.create(1, 3, 4, 2))
                    .build();
            this.wineRepository.save(w);
        }
    }
    @Test
    @DisplayName("와인 데이터")
    void test04() throws Exception {
        String filePath = "/static/images/AURo 제이콥스 크릭, 르 쁘띠 로제.png"; // 클래스패스 상의 경로

        // 파일 경로에서 InputStream 생성
        InputStream inputStream = getClass().getResourceAsStream(filePath);
        byte[] content = inputStream.readAllBytes();
        MultipartFile multipartFile = new MockMultipartFile("file", "AURo 제이콥스 크릭, 르 쁘띠 로제.png", "image/png", content);

        List<Board> boards = boardService.addBoard(List.of(multipartFile));

        for (Board board : boards) {
            Wine w = Wine.builder()
                    .wineName("도멘 미쉘 그로, 본 로마네 프르미에 크뤼 '끌로 드 레아' 모노폴")
                    .wineNameE("Domaine Michel Gros, Vosne Romanee 1er Cru 'Clos des Reas' Monopole")
                    .country("프랑스")
                    .list("레드")
                    .price(760000)
                    .food("치즈, 해산물")
                    .score(4)
                    .kind("피노 누아 100%")
                    .board(board)
                    .createDate(LocalDateTime.now())
                    .taste(tasteService.create(1, 3, 3, 4))
                    .build();
            this.wineRepository.save(w);
        }
    }
    @Test
    @DisplayName("와인 데이터")
    void test05() throws Exception {
        String filePath = "/static/images/AURo 제이콥스 크릭, 르 쁘띠 로제.png"; // 클래스패스 상의 경로

        // 파일 경로에서 InputStream 생성
        InputStream inputStream = getClass().getResourceAsStream(filePath);
        byte[] content = inputStream.readAllBytes();
        MultipartFile multipartFile = new MockMultipartFile("file", "AURo 제이콥스 크릭, 르 쁘띠 로제.png", "image/png", content);

        List<Board> boards = boardService.addBoard(List.of(multipartFile));

        for (Board board : boards) {
            Wine w = Wine.builder()
                    .wineName("도멘 페르드리 에세조 그랑 크뤼")
                    .wineNameE("Domaine des Perdrix Echezeaux Grand Cru")
                    .country("프랑스")
                    .list("레드")
                    .price(650000)
                    .food("소, 치킨, 해산물, 치즈, 샐러드")
                    .score(5)
                    .kind("피노 누아")
                    .board(board)
                    .createDate(LocalDateTime.now())
                    .taste(tasteService.create(1, 3, 4, 3))
                    .build();
            this.wineRepository.save(w);
        }
    }
    @Test
    @DisplayName("와인 데이터")
    void test06() throws Exception {
        String filePath = "/static/images/AUS 낫 데디.png"; // 클래스패스 상의 경로

        // 파일 경로에서 InputStream 생성
        InputStream inputStream = getClass().getResourceAsStream(filePath);
        byte[] content = inputStream.readAllBytes();
        MultipartFile multipartFile = new MockMultipartFile("file", "AUS 낫 데디.png", "image/png", content);

        List<Board> boards = boardService.addBoard(List.of(multipartFile));

        for (Board board : boards) {
            Wine w = Wine.builder()
                    .wineName("까브 드 루그니, 마콩 루그니 유진 블랑 샤르도네")
                    .wineNameE("Cave de Lugny, Macon Lugny Eugene Blanc Chardonnay")
                    .country("프랑스")
                    .list("화이트")
                    .price(75000)
                    .food("치킨, 해산물, 치즈, 양식, 중식")
                    .score(5)
                    .kind("샤르도네 100%")
                    .board(board)
                    .createDate(LocalDateTime.now())
                    .taste(tasteService.create(1, 3, 4, 3))
                    .build();
            this.wineRepository.save(w);
        }
    }
    @Test
    @DisplayName("와인 데이터")
    void test07() throws Exception {
        String filePath = "/static/images/AW 메르 솔레이, 리저브 샤도네이.jpg"; // 클래스패스 상의 경로

        // 파일 경로에서 InputStream 생성
        InputStream inputStream = getClass().getResourceAsStream(filePath);
        byte[] content = inputStream.readAllBytes();
        MultipartFile multipartFile = new MockMultipartFile("file", "AW 메르 솔레이, 리저브 샤도네이.jpg", "image/jpg", content);

        List<Board> boards = boardService.addBoard(List.of(multipartFile));

        for (Board board : boards) {
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
                    .taste(tasteService.create(1, 3, 4, 3))
                    .build();
            this.wineRepository.save(w);
        }
    }
    @Test
    @DisplayName("와인 데이터")
    void test08() throws Exception {
        String filePath = "/static/images/AUW 펜폴즈, 야타나 샤도네이.png"; // 클래스패스 상의 경로

        // 파일 경로에서 InputStream 생성
        InputStream inputStream = getClass().getResourceAsStream(filePath);
        byte[] content = inputStream.readAllBytes();
        MultipartFile multipartFile = new MockMultipartFile("file", "AUW 펜폴즈, 야타나 샤도네이.png", "image/png", content);

        List<Board> boards = boardService.addBoard(List.of(multipartFile));

        for (Board board : boards) {
            Wine w = Wine.builder()
                    .wineName("도멘 갸데, 레 뻬리에르 모노폴")
                    .wineNameE("Domaine Gadias, Les Perrieres Monopole")
                    .country("프랑스")
                    .list("화이트")
                    .price(0)
                    .food("해산물, 치즈")
                    .score(3)
                    .kind("믈롱 드 부르고뉴 100%")
                    .board(board)
                    .createDate(LocalDateTime.now())
                    .taste(tasteService.create(2, 3, 4, 1))
                    .build();
            this.wineRepository.save(w);
        }
    }
    @Test
    @DisplayName("와인 데이터")
    void test09() throws Exception {
        String filePath = "/static/images/CRo 몬테스, 슈럽.png"; // 클래스패스 상의 경로

        // 파일 경로에서 InputStream 생성
        InputStream inputStream = getClass().getResourceAsStream(filePath);
        byte[] content = inputStream.readAllBytes();
        MultipartFile multipartFile = new MockMultipartFile("file", "CRo 몬테스, 슈럽.png", "image/png", content);

        List<Board> boards = boardService.addBoard(List.of(multipartFile));

        for (Board board : boards) {
            Wine w = Wine.builder()
                    .wineName("도멘 루 페레 에 피스, 생-토뱅 자디")
                    .wineNameE("Domaine Roux Pere & Fils, Saint-Aubin Jadis")
                    .country("프랑스")
                    .list("화이트")
                    .price(105000)
                    .food("치킨, 해산물, 치즈, 양식, 중식 ")
                    .score(4)
                    .kind("샤르도네 100%")
                    .board(board)
                    .createDate(LocalDateTime.now())
                    .taste(tasteService.create(1, 3, 3, 1))
                    .build();
            this.wineRepository.save(w);
        }
    }
    @Test
    @DisplayName("와인 데이터")
    void test10() throws Exception {
        String filePath = "/static/images/AW 메르 솔레이, 리저브 샤도네이.jpg"; // 클래스패스 상의 경로

        // 파일 경로에서 InputStream 생성
        InputStream inputStream = getClass().getResourceAsStream(filePath);
        byte[] content = inputStream.readAllBytes();
        MultipartFile multipartFile = new MockMultipartFile("file", "AW 메르 솔레이, 리저브 샤도네이.jpg", "image/jpg", content);

        List<Board> boards = boardService.addBoard(List.of(multipartFile));

        for (Board board : boards) {
            Wine w = Wine.builder()
                    .wineName("도멘 뮈르뮈리움, 루싼느")
                    .wineNameE("Domaine Mur Mur Ium, Roussanne")
                    .country("프랑스")
                    .list("화이트")
                    .price(990000)
                    .food("돼지, 해산물, 치킨, 치즈, 양식")
                    .score(3)
                    .kind("루산느 100%")
                    .board(board)
                    .createDate(LocalDateTime.now())
                    .taste(tasteService.create(1, 3, 3, 1))
                    .build();
            this.wineRepository.save(w);
        }
    }
    @Test
    @DisplayName("와인 데이터")
    void test11() throws Exception {
        String filePath = "/static/images/CR 미션 드 렝고, 뀌베 카베르네 소비뇽.jpg"; // 클래스패스 상의 경로

        // 파일 경로에서 InputStream 생성
        InputStream inputStream = getClass().getResourceAsStream(filePath);
        byte[] content = inputStream.readAllBytes();
        MultipartFile multipartFile = new MockMultipartFile("file", "CR 미션 드 렝고, 뀌베 카베르네 소비뇽.jpg", "image/jpg", content);

        List<Board> boards = boardService.addBoard(List.of(multipartFile));

        for (Board board : boards) {
            Wine w = Wine.builder()
                    .wineName("뤼나르, 브뤼")
                    .wineNameE("Ruinart, Brut")
                    .country("프랑스")
                    .list("스파클링")
                    .price(130000)
                    .food("해산물, 치즈, 샐러드, 과일, 일식,디저트")
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
    @DisplayName("와인 데이터")
    void test12() throws Exception {
        String filePath = "/static/images/CW 루이스 펠리페 에드워즈 시그니처 샤도네이.jpg"; // 클래스패스 상의 경로

        // 파일 경로에서 InputStream 생성
        InputStream inputStream = getClass().getResourceAsStream(filePath);
        byte[] content = inputStream.readAllBytes();
        MultipartFile multipartFile = new MockMultipartFile("file", "CW 루이스 펠리페 에드워즈 시그니처 샤도네이.jpg", "image/jpg", content);

        List<Board> boards = boardService.addBoard(List.of(multipartFile));

        for (Board board : boards) {
            Wine w = Wine.builder()
                    .wineName("메종 카스텔, 크레망 드 보르도 브뤼")
                    .wineNameE("Maison Castel, Cremant de Bordeaux Brut")
                    .country("프랑스")
                    .list("스파클링")
                    .price(40000)
                    .food("디저트, 해산물")
                    .score(4)
                    .kind("세미용, 카베르네 프랑")
                    .board(board)
                    .createDate(LocalDateTime.now())
                    .taste(tasteService.create(1, 1, 3, 1))
                    .build();
            this.wineRepository.save(w);
        }
    }
    @Test
    @DisplayName("와인 데이터")
    void test13() throws Exception {
        String filePath = "/static/images/FJ 샤또 롬보.png"; // 클래스패스 상의 경로

        // 파일 경로에서 InputStream 생성
        InputStream inputStream = getClass().getResourceAsStream(filePath);
        byte[] content = inputStream.readAllBytes();
        MultipartFile multipartFile = new MockMultipartFile("file", "FJ 샤또 롬보.png", "image/png", content);

        List<Board> boards = boardService.addBoard(List.of(multipartFile));

        for (Board board : boards) {
            Wine w = Wine.builder()
                    .wineName("뻬에르 피터, 뀌베 스페셜 레 셔띠용")
                    .wineNameE("Pierre Peters, Cuvee Speciale Les Chetillons")
                    .country("프랑스")
                    .list("스파클링")
                    .price(342000)
                    .food("해산물")
                    .score(4)
                    .kind("샤르도네")
                    .board(board)
                    .createDate(LocalDateTime.now())
                    .taste(tasteService.create(1, 1, 3, 1))
                    .build();
            this.wineRepository.save(w);
        }
    }
    @Test
    @DisplayName("와인 데이터")
    void test14() throws Exception {
        String filePath = "/static/images/FR 베리 브라더스 & 러드, 프로방스 로제.jpg"; // 클래스패스 상의 경로

        // 파일 경로에서 InputStream 생성
        InputStream inputStream = getClass().getResourceAsStream(filePath);
        byte[] content = inputStream.readAllBytes();
        MultipartFile multipartFile = new MockMultipartFile("file", "FR 베리 브라더스 & 러드, 프로방스 로제.jpg", "image/jpg", content);

        List<Board> boards = boardService.addBoard(List.of(multipartFile));

        for (Board board : boards) {
            Wine w = Wine.builder()
                    .wineName("샤를 뒤푸, 르 샴 뒤 끌로 블랑 드 블랑")
                    .wineNameE("Charles Dufour, Le Champ du Clos Blanc de Blancs")
                    .country("프랑스")
                    .list("스파클링")
                    .price(0)
                    .food("해산물, 치즈, 샐러드, 일식, 한식, 과일, 디저트")
                    .score(5)
                    .kind("피노 블랑 100%")
                    .board(board)
                    .createDate(LocalDateTime.now())
                    .taste(tasteService.create(1, 2, 5, 1))
                    .build();
            this.wineRepository.save(w);
        }
    }
    @Test
    @DisplayName("와인 데이터")
    void test15() throws Exception {
        String filePath = "/static/images/FS 메종 카스텔, 크레망 드 보르도 브뤼.png"; // 클래스패스 상의 경로

        // 파일 경로에서 InputStream 생성
        InputStream inputStream = getClass().getResourceAsStream(filePath);
        byte[] content = inputStream.readAllBytes();
        MultipartFile multipartFile = new MockMultipartFile("file", "FS 메종 카스텔, 크레망 드 보르도 브뤼.png", "image/png", content);

        List<Board> boards = boardService.addBoard(List.of(multipartFile));

        for (Board board : boards) {
            Wine w = Wine.builder()
                    .wineName("샹파뉴 살롱 S")
                    .wineNameE("Champagne Salon S")
                    .country("프랑스")
                    .list("스파클링")
                    .price(990000)
                    .food("치킨, 양, 치즈")
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
    @DisplayName("와인 데이터")
    void test16() throws Exception {
        String filePath = "/static/images/GS된호프, 리슬링 브륏 나투르 젝트.png"; // 클래스패스 상의 경로

        // 파일 경로에서 InputStream 생성
        InputStream inputStream = getClass().getResourceAsStream(filePath);
        byte[] content = inputStream.readAllBytes();
        MultipartFile multipartFile = new MockMultipartFile("file", "GS된호프, 리슬링 브륏 나투르 젝트.png", "image/png", content);

        List<Board> boards = boardService.addBoard(List.of(multipartFile));

        for (Board board : boards) {
            Wine w = Wine.builder()
                    .wineName("도츠, 아모르 드 도츠 로제")
                    .wineNameE("Deutz, Amour de Deutz Rose")
                    .country("프랑스")
                    .list("로제")
                    .price(780000)
                    .food("해산물")
                    .score(5)
                    .kind("피노누아 70%, 샤르도네 30%")
                    .board(board)
                    .createDate(LocalDateTime.now())
                    .taste(tasteService.create(1, 2, 4, 1))
                    .build();
            this.wineRepository.save(w);
        }
    }
    @Test
    @DisplayName("와인 데이터")
    void test17() throws Exception {
        String filePath = "/static/images/GW 벨트악스 트로켄베렌아우스레제.jpg"; // 클래스패스 상의 경로

        // 파일 경로에서 InputStream 생성
        InputStream inputStream = getClass().getResourceAsStream(filePath);
        byte[] content = inputStream.readAllBytes();
        MultipartFile multipartFile = new MockMultipartFile("file", "GW 벨트악스 트로켄베렌아우스레제.jpg", "image/jpg", content);

        List<Board> boards = boardService.addBoard(List.of(multipartFile));

        for (Board board : boards) {
            Wine w = Wine.builder()
                    .wineName("베리 브라더스 & 러드, 프로방스 로제")
                    .wineNameE("Berry Bros. & Rudd, Provence Rose")
                    .country("프랑스")
                    .list("로제")
                    .price(18900)
                    .food("치킨, 돼지, 해산물, 치즈, 양식")
                    .score(4)
                    .kind("그르나슈50%, 쌩쏘 30%, 시라.쉬라즈 10%, 무르베드르 10%")
                    .board(board)
                    .createDate(LocalDateTime.now())
                    .taste(tasteService.create(1, 2, 3, 1))
                    .build();
            this.wineRepository.save(w);
        }
    }
    @Test
    @DisplayName("와인 데이터")
    void test18() throws Exception {
        String filePath = "/static/images/IR 리베토, 바롤로 세라룽가 달바.jpg"; // 클래스패스 상의 경로

        // 파일 경로에서 InputStream 생성
        InputStream inputStream = getClass().getResourceAsStream(filePath);
        byte[] content = inputStream.readAllBytes();
        MultipartFile multipartFile = new MockMultipartFile("file", "IR 리베토, 바롤로 세라룽가 달바.jpg", "image/jpg", content);

        List<Board> boards = boardService.addBoard(List.of(multipartFile));

        for (Board board : boards) {
            Wine w = Wine.builder()
                    .wineName("빌라 로랑 로제 당주")
                    .wineNameE("Villa Lorane Rose d'Anjou")
                    .country("프랑스")
                    .list("로제")
                    .price(0)
                    .food("중식, 일식, 한식")
                    .score(3)
                    .kind("카베르데 프랑 100%")
                    .board(board)
                    .createDate(LocalDateTime.now())
                    .taste(tasteService.create(2, 3, 3, 1))
                    .build();
            this.wineRepository.save(w);
        }
    }
    @Test
    @DisplayName("와인 데이터")
    void test19() throws Exception {
        String filePath = "/static/images/IW  깐티네 포베로, 모스카토 다스티 '캄포 델 팔리오'.jpg"; // 클래스패스 상의 경로

        // 파일 경로에서 InputStream 생성
        InputStream inputStream = getClass().getResourceAsStream(filePath);
        byte[] content = inputStream.readAllBytes();
        MultipartFile multipartFile = new MockMultipartFile("file", "IW  깐티네 포베로, 모스카토 다스티 '캄포 델 팔리오'.jpg", "image/jpg", content);

        List<Board> boards = boardService.addBoard(List.of(multipartFile));

        for (Board board : boards) {
            Wine w = Wine.builder()
                    .wineName("도멘 몽로즈, 솔리스 루멍 로제")
                    .wineNameE("Domaine Montrose, Solis Lumen Rose")
                    .country("프랑스")
                    .list("로제")
                    .price(50000)
                    .food("중식, 일식, 한식")
                    .score(5)
                    .kind("카베르데 프랑 100%")
                    .board(board)
                    .createDate(LocalDateTime.now())
                    .taste(tasteService.create(2, 3, 3, 1))
                    .build();
            this.wineRepository.save(w);
        }
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
