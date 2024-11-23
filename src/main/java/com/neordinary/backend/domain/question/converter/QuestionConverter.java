package com.neordinary.backend.domain.question.converter;

import java.util.Optional;

import com.neordinary.backend.domain.question.dto.QuestionRequestDto;
import com.neordinary.backend.domain.question.dto.QuestionResponseDto;
import com.neordinary.backend.domain.question.entity.Question;
import com.neordinary.backend.domain.room.entity.Room;


public class QuestionConverter {
	public static Question toQuestion(QuestionRequestDto request, Long roomId){
		return Question.builder()
			.question_num(request.getQuestion_num())
			.question_content(request.getQuestion_content())
			.prize_content(request.getPrize_content())
			.prize_name(request.getPrize_name())
			.build();
	}
	public static QuestionResponseDto.CreateQuestionResultDto createQuestionResultDto(Question question){
		return QuestionResponseDto.CreateQuestionResultDto.builder()
			.id(question.getId())
			.question_content(question.getQuestion_content())
			.build();
	}

	public static QuestionResponseDto.questionListDto toQuestionList (Optional<Room> room){
		return QuestionResponseDto.questionListDto.builder()
			.questionList(room.get().getQuestionsList())
			.build();
	}
}
