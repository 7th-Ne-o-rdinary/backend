package com.neordinary.backend.domain.vote.converter;

import com.neordinary.backend.domain.participant.entity.Participant;
import com.neordinary.backend.domain.question.entity.Question;
import com.neordinary.backend.domain.vote.dto.VoteResponseDto;
import com.neordinary.backend.domain.vote.entity.Vote;

public class VoteConverter {

	public static Vote toVote(
		Participant votePeople, Participant votedPeople, Question question){
		return Vote.builder()
			.voter(votePeople)
			.voted(votedPeople)
			.question(question)
			.build();
	}
	public static VoteResponseDto.createVoteResultDto toVoteResult(Vote vote){
		return VoteResponseDto.createVoteResultDto.builder()
			.votePeopleId(vote.getVoter().getId())
			.votedPeopleId(vote.getVoted().getId())
			.build();

	}
}
