package com.neordinary.backend.domain.question.service;

import java.util.Optional;

import com.neordinary.backend.domain.room.exception.RoomNotFoundException;
import org.springframework.stereotype.Service;

import com.neordinary.backend.domain.question.converter.QuestionConverter;
import com.neordinary.backend.domain.question.dto.QuestionResponseDto;
import com.neordinary.backend.domain.room.entity.Room;
import com.neordinary.backend.domain.room.repository.RoomRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService{

	private final RoomRepository roomRepository;

	@Override
	@Transactional
	public QuestionResponseDto.questionListDto getQuestionList(String code){
		Room room = roomRepository.findByCode(code)
				.orElseThrow(() -> new RoomNotFoundException(code));
		return QuestionConverter.toQuestionList(room);
	}
}