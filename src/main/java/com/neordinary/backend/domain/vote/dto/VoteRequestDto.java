package com.neordinary.backend.domain.vote.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VoteRequestDto {
	@Getter
	@Setter
	public class createVoteDto{
		private Long votePeopleId;
		private Long votedPeopleId;
		private Long questionId;


	}
}
