package com.std.sbb.domain.wine.controller;

import com.std.sbb.domain.taste.entity.Taste;
import com.std.sbb.domain.taste.form.TasteForm;
import com.std.sbb.domain.taste.service.TasteService;
import com.std.sbb.domain.wine.entity.Wine;
import com.std.sbb.domain.wine.form.WineForm;
import com.std.sbb.domain.wine.searchType.SearchType;
import com.std.sbb.domain.wine.service.WineService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Controller
@RequestMapping("/article")
public class WineController {

    private final WineService wineService;

    private final TasteService tasteService;
    @GetMapping("/list")
    public String list(Model model, @RequestParam(value = "searchType", defaultValue = "TITLE") SearchType searchType, @RequestParam(value = "page", defaultValue = "0") int page, @RequestParam(value = "kw", defaultValue = "") String kw) {
        Page<Wine> paging = this.wineService.getList(searchType, kw, page);
        model.addAttribute("searchType", searchType);
        model.addAttribute("paging", paging);
        return "wineArticle_list";
    }

    @GetMapping("/create")
    public String articleCreate(Model model){
        model.addAttribute("wineForm", new WineForm());
        model.addAttribute("tasteForm", new TasteForm());
        return "wineArticle_form";
    }

    @PostMapping("/create")
    public String wineCreate(@Valid WineForm wineForm, BindingResult bindingResult,
                             @Valid TasteForm tasteForm, BindingResult tasteBindingResult) {
        if (bindingResult.hasErrors() || tasteBindingResult.hasErrors()) {
            return "wineArticle_form";
        }
        Taste taste = tasteService.create(tasteForm.getSweet(), tasteForm.getBody(), tasteForm.getAcidity(), tasteForm.getTannin());
        this.wineService.create(wineForm.getWineName(), wineForm.getWineNameE(), wineForm.getCountry(), wineForm.getList(), wineForm.getPrice(), wineForm.getKind(), wineForm.getFood(), wineForm.getImage(), taste);

        return "redirect:/";
    }

    @GetMapping("/detail/{id}")
    public String detail(Model model, @PathVariable("id") Long id){
        Wine wine = this.wineService.getWine(id);
        model.addAttribute("wine", wine);
        return "wineArticle_detail";
    }

    @GetMapping("/start")
    public String open(){
        return "open_site";
    }

    @GetMapping("/search")
    public String search() {
        return "idPasswordSearch_form";
    }
}

