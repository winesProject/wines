package com.std.sbb.domain.taste.service;

import com.std.sbb.domain.taste.entity.Taste;
import com.std.sbb.domain.taste.repository.TasteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
}
