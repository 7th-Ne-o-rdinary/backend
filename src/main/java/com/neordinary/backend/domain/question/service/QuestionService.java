package com.neordinary.backend.domain.question.service;

import com.neordinary.backend.domain.question.dto.QuestionRequestDto;
import com.neordinary.backend.domain.question.dto.QuestionResponseDto;

public interface QuestionService {
	QuestionResponseDto.CreateQuestionResultDto createQuestion(QuestionRequestDto questionRequestDto, Long roomId);
	void deleteQuestion(Long questionId);

	QuestionResponseDto.questionListDto getQuestionList(Long roomId);
}
