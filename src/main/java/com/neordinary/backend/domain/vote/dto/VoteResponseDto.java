package com.neordinary.backend.domain.vote.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
public class VoteResponseDto {
	@Builder
	@Getter
	@NoArgsConstructor
	@AllArgsConstructor
	public static class createVoteResultDto{
		Long votePeopleId;
		Long votedPeopleId;


	}

}
