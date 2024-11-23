package com.neordinary.backend.domain.question.converter;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.neordinary.backend.domain.question.dto.QuestionRequestDto;
import com.neordinary.backend.domain.question.dto.QuestionResponseDto;
import com.neordinary.backend.domain.question.entity.Question;
import com.neordinary.backend.domain.room.entity.Room;


public class QuestionConverter {
	public static Question toQuestion(QuestionRequestDto request, Long roomId){
		return Question.builder()
			.questionNum(request.getQuestion_num())
			.questionContent(request.getQuestion_content())
			.prizeContent(request.getPrize_content())
			.prizeName(request.getPrize_name())
			.build();
	}
	public static QuestionResponseDto.CreateQuestionResultDto createQuestionResultDto(Question question){
		return QuestionResponseDto.CreateQuestionResultDto.builder()
			.id(question.getId())
			.question_content(question.getQuestionContent())
			.build();
	}

	public static QuestionResponseDto.questionListDto toQuestionList(Optional<Room> room) {
		List<QuestionResponseDto.QuestionDto> questionDtos = room.get().getQuestionsList().stream()
			.map(question -> new QuestionResponseDto.QuestionDto(
				question.getId(),
				question.getQuestionContent()
			))
			.collect(Collectors.toList());

		return QuestionResponseDto.questionListDto.builder()
			.questionList(questionDtos)
			.build();
	}
}
