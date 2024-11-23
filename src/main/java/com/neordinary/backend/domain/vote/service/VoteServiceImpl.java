package com.neordinary.backend.domain.vote.service;

import org.springframework.stereotype.Service;

import com.neordinary.backend.domain.participant.Entity.Participant;
import com.neordinary.backend.domain.participant.repository.ParticipantRepository;
import com.neordinary.backend.domain.question.entity.Question;
import com.neordinary.backend.domain.question.repository.QuestionRepository;
import com.neordinary.backend.domain.vote.converter.VoteConverter;
import com.neordinary.backend.domain.vote.dto.VoteRequestDto;
import com.neordinary.backend.domain.vote.dto.VoteResponseDto;
import com.neordinary.backend.domain.vote.entity.Vote;
import com.neordinary.backend.domain.vote.repository.VoteRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VoteServiceImpl implements VoteService{
	private final VoteRepository voteRepository;
	private final ParticipantRepository participantRepository;
	private final QuestionRepository questionRepository;



	@Override
	public VoteResponseDto.createVoteResultDto createVote(VoteRequestDto.createVoteDto request){
		Participant votePeople = participantRepository.findById(request.getVotePeopleId())
			.orElseThrow(() -> new IllegalArgumentException("존재하지 않는 투표자" + request.getVotePeopleId()));

		Participant votedPeople = participantRepository.findById(request.getVotedPeopleId())
			.orElseThrow(() -> new IllegalArgumentException("존재하지 않는 투표받는 사람" + request.getVotedPeopleId()));

		Question question = questionRepository.findById(request.getQuestionId())
			.orElseThrow(() -> new IllegalArgumentException("존재하지 않는 질문 " + request.getQuestionId()));
		Vote vote = VoteConverter.toVote(votePeople, votedPeople, question);
		voteRepository.save(vote);
		return VoteConverter.toVoteResult(vote);
	}


}
