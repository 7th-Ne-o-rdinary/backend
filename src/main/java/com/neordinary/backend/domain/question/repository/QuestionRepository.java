package com.neordinary.backend.domain.question.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neordinary.backend.domain.question.entity.Question;

public interface QuestionRepository extends JpaRepository<Question, Long> {

}