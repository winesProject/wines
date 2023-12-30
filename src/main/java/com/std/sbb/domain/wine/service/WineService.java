package com.std.sbb.domain.wine.service;

import com.std.sbb.domain.taste.entity.Taste;
import com.std.sbb.domain.wine.entity.Wine;
import com.std.sbb.domain.wine.repository.WineRepository;
import com.std.sbb.domain.wine.searchType.PriceRange;
import com.std.sbb.domain.wine.searchType.SearchType;
import com.std.sbb.global.imagesfile.entity.Board;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WineService {
    private final WineRepository wineRepository;

    public void create(String wineName, String wineNameE, String country, String list, Integer price, String kind, String food, Integer score, Board board, Taste taste) {
        Wine wine = Wine.builder()
                .wineName(wineName)
                .wineNameE(wineNameE)
                .country(country)
                .list(list)
                .price(price)
                .kind(kind)
                .food(food)
                .score(score)
                .board(board)
                .taste(taste)
                .createDate(LocalDateTime.now())
                .build();
        this.wineRepository.save(wine);

    }

    public List<PriceRange> parsePriceRanges(String price) {
        List<PriceRange> priceRanges = new ArrayList<>();

        // 입력을 공백으로 분할합니다
        String[] ranges = price.split("\\s+");

        for (String range : ranges) {
            // "~"로 범위를 분할합니다
            String[] values = range.split("~");

            int start = Integer.parseInt(values[0]);
            int end;

            if (values.length == 2) {
                end = Integer.parseInt(values[1]);
                priceRanges.add(new PriceRange(start, end));
            } else if (values.length == 1) {
                // 상한 값이 무한대인 경우를 처리합니다
                end = Integer.MAX_VALUE;
                priceRanges.add(new PriceRange(start, end));
            }
        }
        return priceRanges;
    }

    public Page<Wine> getList(List<PriceRange> priceRanges, String country, String list, SearchType searchType, String kw, int page) {
        List<Sort.Order> sorts = new ArrayList<>();
        sorts.add(Sort.Order.desc("createDate"));
        Pageable pageable = PageRequest.of(page, 5, Sort.by(sorts));
        Specification<Wine> spec = _search(priceRanges, country, list, searchType, kw);

        if (StringUtils.isNotBlank(country) && StringUtils.isNotBlank(list) && !priceRanges.isEmpty()) {
            // 1. country와 list, price 값이 모두 비어있지 않다면 해당 country, list, price를 찾음
            int price = priceRanges.get(0).getStart();
            return this.wineRepository.findByCountryAndListAndPrice(country, list, price, priceRanges.get(0).getEnd(), pageable);
        } else if (StringUtils.isNotBlank(country) && !priceRanges.isEmpty()) {
            // 2. country와 price 값이 모두 비어있지 않다면 해당 country, price를 찾음
            int price = priceRanges.get(0).getStart();
            return this.wineRepository.findByCountryAndPrice(country, price, priceRanges.get(0).getEnd(), pageable);
        } else if (StringUtils.isNotBlank(list) && !priceRanges.isEmpty()) {
            // 3. list와 price 값이 모두 비어있지 않다면 해당 list, price 값을 찾음
            int price = priceRanges.get(0).getStart();
            return this.wineRepository.findByListAndPrice(list, price, priceRanges.get(0).getEnd(), pageable);
        } else if (StringUtils.isNotBlank(country) && StringUtils.isNotBlank(list)) {
            // 4. country와 list 값이 모두 비어있지 않다면 해당 country와 list를 찾음
            return this.wineRepository.findByCountryAndList(country, list, pageable);
        } else if (StringUtils.isNotBlank(country)) {
            // 5. country 값은 비어있지 않고, 해당 country를 찾음
            return this.wineRepository.findByCountry(country, pageable);
        } else if (!priceRanges.isEmpty()) {
            // 6. price 값이 비어있지 않을 경우 해당 price를 찾음
            int price = priceRanges.get(0).getStart();
            return this.wineRepository.findByPrice(price, priceRanges.get(0).getEnd(), pageable);
        } else if (StringUtils.isNotBlank(list)) {
            // 7. country 값은 비어있고, list 값이 비어있지 않다면 해당 list를 찾음
            return this.wineRepository.findByList(list, pageable);
        } else {
            // 8. country와 list 값이 모두 비어있거나 country 값이 비어있다면 모든 Wine을 찾음
            return this.wineRepository.findAll(spec, pageable);
        }
    }


    public List<Wine> getList() {
        return this.wineRepository.findAll();
    }

    public Wine getWine(Long id) {
        Optional<Wine> wineOptional = this.wineRepository.findById(id);
        if (wineOptional.isPresent()) {
            return wineOptional.get();
        } else {
            throw new RuntimeException("와인의 정보가 존재하지 않습니다");
        }
    }


    private Specification<Wine> _search(List<PriceRange> priceRanges, String country, String list, SearchType searchType, String kw) {
        return new Specification<>() {
            private static final long serialVersionUID = 1L;

            @Override
            public Predicate toPredicate(Root<Wine> q, CriteriaQuery<?> query, CriteriaBuilder cb) {
                query.distinct(true);
                Predicate predicate = cb.conjunction();

                if (searchType == SearchType.TITLE) {
                    return cb.or(
                            cb.like(q.get("wineName"), "%" + kw + "%"),
                            cb.like(q.get("wineNameE"), "%" + kw + "%")
                    );
                } else if (searchType == SearchType.CONTENT) {
                    return cb.or(
                            cb.like(q.get("country"), "%" + kw + "%"),
                            cb.like(q.get("list"), "%" + kw + "%"),
                            cb.like(q.get("kind"), "%" + kw + "%"),
                            cb.like(q.get("food"), "%" + kw + "%")
                    );
                } else if (searchType == SearchType.TITLEANDCONTENT) {
                    return cb.or(
                            cb.like(q.get("wineName"), "%" + kw + "%"),
                            cb.like(q.get("wineNameE"), "%" + kw + "%"),
                            cb.like(q.get("country"), "%" + kw + "%"),
                            cb.like(q.get("list"), "%" + kw + "%"),
                            cb.like(q.get("kind"), "%" + kw + "%"),
                            cb.like(q.get("food"), "%" + kw + "%")
                    );
                }
                // list 값에 따른 동적 검색 조건 추가
                if (StringUtils.isNotBlank(list)) {
                    String[] listValues = list.split(" ");
                    for (String listValue : listValues) {
                        predicate = cb.or(
                                predicate,
                                cb.like(q.get("list"), "%" + listValue + "%")
                        );
                    }
                }
                // country 값에 따른 동적 검색 조건 추가
                if (StringUtils.isNotBlank(country)) {
                    String[] countryValues = country.split(" ");
                    for (String countryValue : countryValues) {
                        predicate = cb.or(
                                predicate,
                                cb.like(q.get("country"), "%" + countryValue + "%")
                        );
                    }
                }
                // price 값에 따른 동적 검색 조건 추가
                if (!priceRanges.isEmpty()) {
                    List<Predicate> pricePredicates = new ArrayList<>();
                    for (PriceRange priceRange : priceRanges) {
                        pricePredicates.add(
                                cb.between(q.get("price"), priceRange.getStart(), priceRange.getEnd())
                        );
                    }
                    predicate = cb.and(predicate, cb.or(pricePredicates.toArray(new Predicate[0])));
                }

                return cb.conjunction();
            }
        };
    }

    public void modify(Wine wine, String wineName, String wineNameE, String country, String list, Integer price, String kind, String food, Board board, Taste taste) {
        Wine
                .builder()
                .wineName(wineName)
                .wineNameE(wineNameE)
                .country(country)
                .list(list)
                .price(price)
                .kind(kind)
                .food(food)
                .board(board)
                .taste(taste)
                .build();
        this.wineRepository.save(wine);
    }

    public void delete(Wine wine) {
        this.wineRepository.delete(wine);
    }

}