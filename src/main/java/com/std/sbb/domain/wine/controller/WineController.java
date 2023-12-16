package com.std.sbb.domain.wine.controller;

import com.std.sbb.domain.taste.entity.Taste;
import com.std.sbb.domain.taste.form.TasteForm;
import com.std.sbb.domain.taste.service.TasteService;
import com.std.sbb.domain.wine.form.WineForm;
import com.std.sbb.domain.wine.service.WineService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequiredArgsConstructor
@RequestMapping("/article")
public class WineController {
    private final WineService wineService;

    private final TasteService tasteService;

    @PostMapping("/create")
    public String wineCreate(@Valid WineForm wineForm, BindingResult bindingResult,
                             @Valid TasteForm tasteForm, BindingResult tasteBindingResult,
                             @RequestParam("image") MultipartFile imageFile) {
        if (bindingResult.hasErrors() || tasteBindingResult.hasErrors()) {
            return "wineArticle_form";
        }
        byte[] imageBytes;
        try {
            imageBytes = imageFile.getBytes();
        } catch (IOException e) {
            // 오류 처리: 이미지를 바이트 배열로 변환하는 동안 오류가 발생하면 여기에 대한 예외 처리를 추가할 수 있습니다.
            e.printStackTrace();  // 예외 처리를 적절히 수정해주세요.
            return "wineArticle_form";
        }

        Taste taste = tasteService.create(tasteForm.getSweet(), tasteForm.getBody(), tasteForm.getAcidity(), tasteForm.getTannin());
        this.wineService.create(wineForm.getWineName(), wineForm.getCountry(), wineForm.getList(), wineForm.getPrice(), wineForm.getKind(), wineForm.getFood(), imageBytes, taste);

        return "redirect:/";
    }
}
