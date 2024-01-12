package com.std.sbb.domain.wine.searchType;

import lombok.Data;

@Data
public class PriceRange {
    private int start;
    private int end;

    public PriceRange(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
