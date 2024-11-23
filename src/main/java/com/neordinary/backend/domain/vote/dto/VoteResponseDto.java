package com.neordinary.backend.domain.vote.dto;
import java.util.List;

import com.neordinary.backend.domain.question.dto.QuestionResponseDto;

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

	@Builder
	@Getter
	//@NoArgsConstructor
	@AllArgsConstructor
	public static class VoteResultDto{
		Long questionId;
		String roomName;
		String prizeName;
		String userName;
		String prizeContent;
		Long voteCount;

	}





}
