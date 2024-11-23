package com.neordinary.backend.domain.vote.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public class VoteResultDto {
	private Long questionId;
	private String roomName;
	private String prizeName;
	private String userName;
	private String prizeContent;
	private Long voteCount;
}
