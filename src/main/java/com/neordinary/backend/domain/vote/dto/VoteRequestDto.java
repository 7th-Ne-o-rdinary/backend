package com.neordinary.backend.domain.vote.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VoteRequestDto {
	@Getter
	@Setter
	public static class createVoteDto{
		private String  votePeopleEmail;
		private String votedPeopleEmail;
		private Long questionId;


	}
}
