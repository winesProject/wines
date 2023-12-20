package com.std.sbb.domain.question.service;

import com.std.sbb.domain.question.entity.Question;
import com.std.sbb.domain.question.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QuestionService {
    private final QuestionRepository questionRepository;
    public List<Question> getList() {
        return this.questionRepository.findAll();
    }

    public Question getId(Long id) {
        Optional<Question> question = this.questionRepository.findById(id);
        return question.get();
    }

    public void create(String article, String content) {
        Question question = Question
                .builder()
                .article(article)
                .content(content)
                .createDate(LocalDateTime.now())
                .build();
        this.questionRepository.save(question);
    }
}
