package com.std.sbb.domain.wine.repository;

import com.std.sbb.domain.wine.entity.Wine;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface WineRepository extends JpaRepository<Wine, Long> {

    Page<Wine> findAll(Specification<Wine> spec, Pageable pageable);
    Page<Wine> findAll(Pageable pageable);

    @Query("SELECT w FROM Wine w WHERE :list IS NULL OR :list IN (w.list)")
    Page<Wine> findByList(@Param("list") String list, Pageable pageable);

    @Query("SELECT w FROM Wine w WHERE :country IS NULL OR :country IN (w.country)")
    Page<Wine> findByCountry(@Param("country") String country, Pageable pageable);

    @Query("SELECT w FROM Wine w WHERE :country IS NULL OR :country IN (w.country) AND :list IS NULL OR :list IN (w.list)")
    Page<Wine> findByCountryAndList(@Param("country") String country, @Param("list") String list, Pageable pageable);

    @Query("SELECT w FROM Wine w WHERE (:country IS NULL OR :country IN (w.country)) AND (:list IS NULL OR :list IN (w.list)) AND (:priceStart = 0 OR (w.price >= :priceStart AND w.price <= :priceEnd))")
    Page<Wine> findByCountryAndListAndPrice(@Param("country") String country, @Param("list") String list, @Param("priceStart") int priceStart, @Param("priceEnd") int priceEnd, Pageable pageable);

    @Query("SELECT w FROM Wine w WHERE :list IS NULL OR :list IN (w.list) AND (:priceStart = 0 OR (w.price >= :priceStart AND w.price <= :priceEnd))")
    Page<Wine> findByListAndPrice(@Param("list") String list, @Param("priceStart") int priceStart, @Param("priceEnd") int priceEnd, Pageable pageable);

    @Query("SELECT w FROM Wine w WHERE w.price >= :start AND w.price <= :end")
    Page<Wine> findByPrice(@Param("start") int start, @Param("end") int end, Pageable pageable);

    @Query("SELECT w FROM Wine w WHERE (:country IS NULL OR :country IN (w.country)) AND (:start = 0 OR w.price >= :start) AND (:end = 0 OR w.price <= :end)")
    Page<Wine> findByCountryAndPrice(@Param("country") String country, @Param("start") int start, @Param("end") int end, Pageable pageable);

    @Query("SELECT w FROM Wine w WHERE (:food IS NULL OR w.food LIKE CONCAT('%', :food, '%'))")
    Page<Wine> findByFood(@Param("food") String food, Pageable pageable);

    @Query("SELECT w FROM Wine w WHERE (:list IS NULL OR :list IN (w.list)) AND (:food IS NULL OR w.food LIKE CONCAT('%', :food, '%'))")
    Page<Wine> findByListAndFood(@Param("list") String list, @Param("food") String food, Pageable pageable);

    @Query("SELECT w FROM Wine w WHERE (:country IS NULL OR :country IN (w.country)) AND (:food IS NULL OR w.food LIKE CONCAT('%', :food, '%'))")
    Page<Wine> findByCountryAndFood(@Param("country") String country, @Param("food") String food, Pageable pageable);

    @Query("SELECT w FROM Wine w WHERE (:start = 0 OR w.price >= :start) AND (:end = 0 OR w.price <= :end) AND (:food IS NULL OR w.food LIKE CONCAT('%', :food, '%'))")
    Page<Wine> findByPriceAndFood(@Param("start") int start, @Param("end") int end, @Param("food") String food, Pageable pageable);

    @Query("SELECT w FROM Wine w WHERE (:list IS NULL OR :list IN (w.list)) AND (:country IS NULL OR :country IN (w.country)) AND (:food IS NULL OR w.food LIKE CONCAT('%', :food, '%'))")
    Page<Wine> findByListAndCountryAndFood(@Param("list") String list, @Param("country") String country, @Param("food") String food, Pageable pageable);

    @Query("SELECT w FROM Wine w WHERE (:list IS NULL OR :list IN (w.list)) AND (:start = 0 OR w.price >= :start) AND (:end = 0 OR w.price <= :end) AND (:food IS NULL OR w.food LIKE CONCAT('%', :food, '%'))")
    Page<Wine> findByListAndPriceAndFood(@Param("list") String list, @Param("start") int start, @Param("end") int end, @Param("food") String food, Pageable pageable);

    @Query("SELECT w FROM Wine w WHERE (:country IS NULL OR :country IN (w.country)) AND (:start = 0 OR w.price >= :start) AND (:end = 0 OR w.price <= :end) AND (:food IS NULL OR w.food LIKE CONCAT('%', :food, '%'))")
    Page<Wine> findByCountryAndPriceAndFood(@Param("country") String country, @Param("start") int start, @Param("end") int end, @Param("food") String food, Pageable pageable);

    @Query("SELECT w FROM Wine w WHERE (:list IS NULL OR :list IN (w.list)) AND (:country IS NULL OR :country IN (w.country)) AND (:start = 0 OR w.price >= :start) AND (:end = 0 OR w.price <= :end) AND (:food IS NULL OR w.food LIKE CONCAT('%', :food, '%'))")
    Page<Wine> findByListAndCountryAndPriceAndFood(@Param("list") String list, @Param("country") String country, @Param("start") int start, @Param("end") int end, @Param("food") String food, Pageable pageable);
}