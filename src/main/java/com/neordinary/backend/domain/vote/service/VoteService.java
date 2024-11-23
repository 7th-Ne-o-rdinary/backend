package com.neordinary.backend.domain.vote.service;

import com.neordinary.backend.domain.vote.dto.VoteRequestDto;
import com.neordinary.backend.domain.vote.dto.VoteResponseDto;

public interface VoteService {


	VoteResponseDto.createVoteResultDto createVote(VoteRequestDto.createVoteDto request);
}
