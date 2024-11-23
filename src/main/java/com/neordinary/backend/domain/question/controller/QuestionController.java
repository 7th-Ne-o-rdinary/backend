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



	@GetMapping("/list/{questionId}")
	@Operation(summary="질문 목록 조회 API")
	public ResponseEntity<QuestionResponseDto.questionListDto> questionList(@PathVariable(name="questionId") Long questionId){
		QuestionResponseDto.questionListDto questionList =questionService.getQuestionList(questionId);
		return ResponseEntity.ok(questionList);
	}



}
