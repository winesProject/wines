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

@Controller
@RequiredArgsConstructor
public class WineController {
    private final WineService wineService;

    private final TasteService tasteService;

    @PostMapping("/article/create")
    public String wineCreate(@Valid WineForm wineForm, BindingResult bindingResult, TasteForm tasteForm){
        if (bindingResult.hasErrors()){
            return "wineArticle_form";
        }
        Taste taste = tasteService.create(tasteForm.getSweet(), tasteForm.getBody(), tasteForm.getAcidity(), tasteForm.getTannin());
        this.wineService.create(wineForm.getWineName(), wineForm.getCountry(),wineForm.getList(),wineForm.getPrice(),wineForm.getKind(),wineForm.getFood(),wineForm.getImage(),taste);
        return "redirect:/";
    }

}
