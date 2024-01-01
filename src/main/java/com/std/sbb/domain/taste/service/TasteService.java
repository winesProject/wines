package com.std.sbb.domain.taste.service;

import com.std.sbb.domain.taste.entity.Taste;
import com.std.sbb.domain.taste.repository.TasteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TasteService {

    private final TasteRepository tasteRepository;

    public Taste create(Integer sweet, Integer body, Integer acidity, Integer tannin) {
        Taste taste = Taste.builder()
                .sweet(sweet)
                .body(body)
                .acidity(acidity)
                .tannin(tannin)
                .build();
        this.tasteRepository.save(taste);
        return taste;
    }
    public Taste getTaste(Long id) {
        Optional<Taste> ot = this.tasteRepository.findById(id);
        if (ot.isPresent()) {
            return ot.get();
        } else {
            throw new RuntimeException("맛이 존재하지 않습니다");
        }
    }

    public Taste modify(Taste taste, Integer sweet, Integer body, Integer acidity, Integer tannin) {
        taste.setSweet(sweet);
        taste.setBody(body);
        taste.setAcidity(acidity);
        taste.setTannin(tannin);
        return this.tasteRepository.save(taste);
    }
}
