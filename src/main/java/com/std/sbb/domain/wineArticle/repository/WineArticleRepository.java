package com.std.sbb.domain.wineArticle.repository;

import com.std.sbb.domain.wineArticle.entity.WineArticle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WineArticleRepository extends JpaRepository<WineArticle, Long> {
}
