package com.std.sbb.domain.questionArticle.repository;

import com.std.sbb.domain.questionArticle.entity.QuestionArticle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionArticleRepository extends JpaRepository<QuestionArticle, Long> {
}
