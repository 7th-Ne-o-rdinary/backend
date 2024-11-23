package com.neordinary.backend.domain.vote.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neordinary.backend.domain.vote.dto.VoteRequestDto;
import com.neordinary.backend.domain.vote.dto.VoteResponseDto;
import com.neordinary.backend.domain.vote.service.VoteService;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/vote")
@RequiredArgsConstructor
public class VoteController {
	private final VoteService voteService;

	@PostMapping("/")
	@Operation(summary="투표 API")
	public ResponseEntity<VoteResponseDto.createVoteResultDto> createVote (@RequestBody VoteRequestDto.createVoteDto request){
		VoteResponseDto.createVoteResultDto createVoteResultDto = voteService.createVote(request);
		return ResponseEntity.ok(createVoteResultDto);
	}

}
