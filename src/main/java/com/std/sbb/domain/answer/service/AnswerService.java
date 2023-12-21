package com.std.sbb.domain.answer.service;

import com.std.sbb.domain.answer.entity.Answer;
import com.std.sbb.domain.answer.repository.AnswerRepository;
import com.std.sbb.domain.question.entity.Question;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AnswerService {
    private final AnswerRepository answerRepository;

    public void create(Question question, String content) {
        Answer answer = Answer
                .builder()
                .content(content)
                .question(question)
                .createDate(LocalDateTime.now())
                .build();
        this.answerRepository.save(answer);
    }
}
