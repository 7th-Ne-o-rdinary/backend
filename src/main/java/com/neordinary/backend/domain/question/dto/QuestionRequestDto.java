package com.neordinary.backend.domain.question.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
public class QuestionRequestDto {
	@NotBlank
	String question_content;
	@Positive
	Integer question_num;
	@NotBlank
	String prize_name;
	@NotBlank
	String prize_content;



}
