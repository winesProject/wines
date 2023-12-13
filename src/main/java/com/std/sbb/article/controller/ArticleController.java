package com.std.sbb.article.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
@RequestMapping("/article")
public class ArticleController {

    @GetMapping("/list")
    public String list(){
        return "article_list";
    }

    @GetMapping("/create")
    public String articleCreate(){
        return "article_form";
    }

    @GetMapping("/detail")
    public String detail(){
        return "article_detail";
    }
}
