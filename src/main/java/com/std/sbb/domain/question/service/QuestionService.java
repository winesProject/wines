package com.std.sbb.domain.question.service;

import com.std.sbb.domain.member.entity.Member;
import com.std.sbb.domain.question.entity.Question;
import com.std.sbb.domain.question.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QuestionService {
    private final QuestionRepository questionRepository;
    public Page<Question> getList(int page) {
        List<Sort.Order> sorts = new ArrayList<>();
        sorts.add(Sort.Order.desc("createDate"));
        Pageable pageable = PageRequest.of(page, 10, Sort.by(sorts));
        return this.questionRepository.findAll(pageable);
    }

    public Question getId(Long id) {
        Optional<Question> question = this.questionRepository.findById(id);
        return question.get();
    }

    public void create(String article, String content, Member member) {
        Question question = Question
                .builder()
                .article(article)
                .content(content)
                .createDate(LocalDateTime.now())
                .member(member)
                .build();
        this.questionRepository.save(question);
    }

    public void delete(Question question) {
        this.questionRepository.delete(question);
    }
}
