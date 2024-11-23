package com.neordinary.backend.domain.question.service;

import com.neordinary.backend.domain.question.dto.QuestionResponseDto;

public interface QuestionService {
	QuestionResponseDto.questionListDto getQuestionList(String code);
}
