package com.neordinary.backend.domain.question.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neordinary.backend.domain.question.dto.QuestionRequestDto;
import com.neordinary.backend.domain.question.dto.QuestionResponseDto;
import com.neordinary.backend.domain.question.service.QuestionService;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/question")
public class QuestionController {
	private final QuestionService questionService;

	@PostMapping("/create/{roomId}")
	//@Operation(summary="질문 생성 API")
	public ResponseEntity<QuestionResponseDto.CreateQuestionResultDto> createQuestion(@RequestBody QuestionRequestDto request, @PathVariable(name="roomId") Long roomId){
		QuestionResponseDto.CreateQuestionResultDto questionResponseDto = questionService.createQuestion(request,roomId);
		return ResponseEntity.ok(questionResponseDto);
	}

	@DeleteMapping("/delete")
	//@Operation(summary="질문 삭제 API")
	public ResponseEntity<Void> removeQuestion (@RequestBody Long questionId){
		questionService.deleteQuestion(questionId);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/list/{roomId}")
	@Operation(summary="질문 목록 조회 API")
	public ResponseEntity<QuestionResponseDto.questionListDto> questionList(@PathVariable(name="roomId") Long roomId){
		QuestionResponseDto.questionListDto questionList =questionService.getQuestionList(roomId);
		return ResponseEntity.ok(questionList);
	}



}
