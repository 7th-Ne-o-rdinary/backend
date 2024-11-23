package com.neordinary.backend.domain.question.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
public class QuestionRequestDto {
	String question_content;
	Integer question_num;
	String prize_name;
	String prize_content;



}
