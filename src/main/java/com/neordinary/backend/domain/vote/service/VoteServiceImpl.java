package com.neordinary.backend.domain.vote.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.neordinary.backend.domain.room.entity.Room;
import com.neordinary.backend.domain.vote.exception.NotFinishedVoteException;
import org.springframework.stereotype.Service;

import com.neordinary.backend.domain.participant.entity.Participant;
import com.neordinary.backend.domain.participant.repository.ParticipantRepository;
import com.neordinary.backend.domain.question.entity.Question;
import com.neordinary.backend.domain.question.repository.QuestionRepository;
import com.neordinary.backend.domain.room.repository.RoomRepository;
import com.neordinary.backend.domain.user.domain.User;
import com.neordinary.backend.domain.vote.converter.VoteConverter;
import com.neordinary.backend.domain.vote.dto.VoteRequestDto;
import com.neordinary.backend.domain.vote.dto.VoteResponseDto;
import com.neordinary.backend.domain.vote.dto.VoteResultDto;
import com.neordinary.backend.domain.vote.entity.Vote;
import com.neordinary.backend.domain.vote.exception.VoteBadRequestException;
import com.neordinary.backend.domain.vote.exception.VoteNotFoundException;
import com.neordinary.backend.domain.vote.exception.VoteServiceException;
import com.neordinary.backend.domain.vote.repository.VoteRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VoteServiceImpl implements VoteService{
	private final VoteRepository voteRepository;
	private final ParticipantRepository participantRepository;
	private final QuestionRepository questionRepository;
	private final RoomRepository roomRepository;



	@Override
	public List<VoteResultDto> getVoteResult(Long questionId) {
		List<VoteResultDto> results = voteRepository.findTopVoteResultByQuestionId(questionId);

		Question question = questionRepository.findById(questionId)
				.orElseThrow(() -> new VoteNotFoundException());

		Room room = question.getRoom();
		List<Participant> participants = participantRepository.findByRoomId(room.getId());
		List<Vote> byQuestionId = voteRepository.findByQuestionId(questionId);

		if (participants.size() > byQuestionId.size()) {
			throw new NotFinishedVoteException();
		}

		if (results.isEmpty()) {
			throw new VoteServiceException();
		}
		return results;
	}


	@Override
	public VoteResponseDto.createVoteResultDto createVote(User user, VoteRequestDto.createVoteDto request){
		Question question = questionRepository.findById(request.getQuestionId())
			.orElseThrow(() -> new VoteNotFoundException());
		if (user.getEmail().equals(request.getVotedPeopleEmail())) {
			throw new VoteBadRequestException();
		}
		Participant votePeople = participantRepository.findByUserEmailAndRoomId(user.getEmail(), question.getRoom().getId())
			.orElseThrow(() -> new VoteNotFoundException());

		Participant votedPeople = participantRepository.findByUserEmailAndRoomId(request.getVotedPeopleEmail(),question.getRoom().getId())
			.orElseThrow(() -> new VoteNotFoundException());

		Vote vote = VoteConverter.toVote(votePeople, votedPeople, question);
		voteRepository.save(vote);
		return VoteConverter.toVoteResult(vote);
	}



}