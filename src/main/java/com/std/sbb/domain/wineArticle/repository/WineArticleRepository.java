package com.std.sbb.domain.wineArticle.repository;

import com.std.sbb.domain.member.entity.Member;
import com.std.sbb.domain.wine.entity.Wine;
import com.std.sbb.domain.wineArticle.entity.WineArticle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WineArticleRepository extends JpaRepository<WineArticle, Long> {

}
