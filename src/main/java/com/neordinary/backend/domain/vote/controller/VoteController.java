package com.neordinary.backend.domain.vote.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neordinary.backend.domain.vote.dto.VoteResponseDto;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/vote")
@RequiredArgsConstructor
public class VoteController {
	private

	@PostMapping("/")
	@Operation(summary="투표 API")
	public ResponseEntity<VoteResponseDto.createVoteResultDto> createVote (@Re)

}
