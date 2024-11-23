package com.neordinary.backend.domain.question.repository;

import com.neordinary.backend.domain.question.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}