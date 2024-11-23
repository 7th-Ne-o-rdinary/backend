package com.neordinary.backend.domain.vote.service;

import java.util.List;

import com.neordinary.backend.domain.user.domain.User;
import com.neordinary.backend.domain.vote.dto.VoteRequestDto;
import com.neordinary.backend.domain.vote.dto.VoteResponseDto;
import com.neordinary.backend.domain.vote.dto.VoteResultDto;

public interface VoteService {
	List<VoteResultDto> getVoteResult(Long questionId);



	VoteResponseDto.createVoteResultDto createVote(User user,VoteRequestDto.createVoteDto request);
}
