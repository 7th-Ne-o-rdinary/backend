package com.neordinary.backend.domain.question.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class QuestionResponseDto {
	@Builder
	@Getter
	@NoArgsConstructor
	@AllArgsConstructor
	public static class CreateQuestionResultDto{
		Long id;
		String question_content;


	}
	@Builder
	@Getter
	@NoArgsConstructor
	@AllArgsConstructor
	public static class questionListDto{
		List<QuestionDto> questionList;
	}

	@Getter
	@NoArgsConstructor
	@AllArgsConstructor
	public static class QuestionDto {
		private Long questionId;
		private String questionContent;

	}





}