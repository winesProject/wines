package com.std.sbb.global.imagesfile.controller;

import com.std.sbb.global.imagesfile.entity.Board;
import com.std.sbb.global.imagesfile.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/board")
    public String getBoard(@RequestParam long id) {
        Board board = boardService.findBoard(id).orElseThrow(RuntimeException::new);
        String imgPath = board.getStoredFileName();

        return "<img src=" + imgPath + ">";
    }
}