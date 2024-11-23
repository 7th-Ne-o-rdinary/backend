package com.neordinary.backend.domain.question.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.neordinary.backend.domain.question.converter.QuestionConverter;
import com.neordinary.backend.domain.question.dto.QuestionRequestDto;
import com.neordinary.backend.domain.question.dto.QuestionResponseDto;
import com.neordinary.backend.domain.question.entity.Question;
import com.neordinary.backend.domain.question.repository.QuestionRepository;
import com.neordinary.backend.domain.room.entity.Room;
import com.neordinary.backend.domain.room.repository.RoomRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService{
	private final QuestionRepository questionRepository;
	private final RoomRepository roomRepository;
	@Override
	public  QuestionResponseDto.CreateQuestionResultDto createQuestion(QuestionRequestDto request, Long roomId){
		Question question = QuestionConverter.toQuestion(request,roomId);
		questionRepository.save(question);
		return QuestionConverter.createQuestionResultDto(question);

	}
	@Override
	public void deleteQuestion(Long questionId){
		questionRepository.deleteById(questionId);
	}

	@Override
	public QuestionResponseDto.questionListDto getQuestionList(Long roomId){
		Optional<Room> room= roomRepository.findById(roomId);
		return QuestionConverter.toQuestionList(room);
	}
}
