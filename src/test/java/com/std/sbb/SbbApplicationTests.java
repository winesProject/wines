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
    @DisplayName("와인 데이터")
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
    void testJpa() {
        for (int i = 1; i <= 100; i++) {
            String subject = String.format("테스트 데이터입니다:[%03d]", i);
            String content = "내용무";
            this.questionService.create(subject, content, null);
        }
    }
}

