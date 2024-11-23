package com.neordinary.backend.domain.question.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class QuestionResponseDto {
	@Builder
	@Getter
	@NoArgsConstructor
	@AllArgsConstructor
	public static class CreateQuestionResultDto{
		Long id;
		String question_content;


	}
}
