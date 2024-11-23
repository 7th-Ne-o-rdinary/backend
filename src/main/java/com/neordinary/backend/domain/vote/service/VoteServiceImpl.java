package com.neordinary.backend.domain.vote.service;

import org.springframework.stereotype.Service;

import com.neordinary.backend.domain.participant.entity.Participant;
import com.neordinary.backend.domain.participant.repository.ParticipantRepository;
import com.neordinary.backend.domain.question.entity.Question;
import com.neordinary.backend.domain.question.repository.QuestionRepository;
import com.neordinary.backend.domain.vote.converter.VoteConverter;
import com.neordinary.backend.domain.vote.dto.VoteRequestDto;
import com.neordinary.backend.domain.vote.dto.VoteResponseDto;
import com.neordinary.backend.domain.vote.entity.Vote;
import com.neordinary.backend.domain.vote.exception.VoteNotFoundException;
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
		Participant votePeople = participantRepository.findByUserEmail(request.getVotePeopleEmail())
			.orElseThrow(() -> new VoteNotFoundException());

		Participant votedPeople = participantRepository.findByUserEmail(request.getVotedPeopleEmail())
			.orElseThrow(() -> new VoteNotFoundException());

		Question question = questionRepository.findById(request.getQuestionId())
			.orElseThrow(() -> new VoteNotFoundException());
		Vote vote = VoteConverter.toVote(votePeople, votedPeople, question);
		voteRepository.save(vote);
		return VoteConverter.toVoteResult(vote);
	}


}