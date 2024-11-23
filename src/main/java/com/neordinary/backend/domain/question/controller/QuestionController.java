package com.neordinary.backend.domain.question.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neordinary.backend.domain.question.dto.QuestionResponseDto;
import com.neordinary.backend.domain.question.service.QuestionService;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/question")
public class QuestionController {

	private final QuestionService questionService;

	@GetMapping("/list/{code}")
	@Operation(summary="질문 목록 조회 API", description = """
            # 질문 목록 조회 API

            - pathVariable로 roomId 받음
            - 해당 방에 존재하는 질문들을 리스트 형식으로 반환
            """)
	public ResponseEntity<QuestionResponseDto.questionListDto> questionList(@PathVariable(name="code") String code){
		QuestionResponseDto.questionListDto questionList =questionService.getQuestionList(code);
		return ResponseEntity.ok(questionList);
	}
}