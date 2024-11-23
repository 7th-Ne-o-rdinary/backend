package com.neordinary.backend.domain.room.service;

import com.neordinary.backend.domain.participant.dto.ParticipantDto;
import com.neordinary.backend.domain.participant.entity.Participant;
import com.neordinary.backend.domain.participant.repository.ParticipantRepository;
import com.neordinary.backend.domain.question.dto.RequestQuestion;
import com.neordinary.backend.domain.question.entity.Question;
import com.neordinary.backend.domain.question.repository.QuestionRepository;
import com.neordinary.backend.domain.room.dto.RequestCreateRoom;
import com.neordinary.backend.domain.room.dto.StartRoomDto;
import com.neordinary.backend.domain.room.dto.RoomCodeDto;
import com.neordinary.backend.domain.room.entity.Room;
import com.neordinary.backend.domain.room.exception.InvalidRoomForParticipateException;
import com.neordinary.backend.domain.room.exception.RoomNotFoundException;
import com.neordinary.backend.domain.room.repository.RoomRepository;
import com.neordinary.backend.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {

    private static final String IN_PROGRESS = "진행 중";
    private static final String IN_AVAILABLE_CODE = "유효하지 않은 코드: ";
    private static final String STATUS = "시작 전";
    private static final String FORBIDDEN_STATUS ="방에 참여할 수 없는 상태입니다: ";

    private final RoomRepository roomRepository;
    private final QuestionRepository questionRepository;
    private final ParticipantRepository participantRepository;


    @Override
    @Transactional
    public RoomCodeDto create(User user, RequestCreateRoom requestCreateRoom) {
        Room room = requestCreateRoom.toEntity();
        room.setCode(createAccountNum());
        room.setUser(user);
        roomRepository.save(room);

        List<Question> questions = mappingQuestion(requestCreateRoom.getQuestions(), room);
        questionRepository.saveAll(questions);

        participantRepository.save(mappingParticipant(user, room));

        return RoomCodeDto.builder()
                .code(room.getCode())
                .build();
    }

    @Override
    @Transactional
    public void join(User user, String code) {

        Room room = checkRoomCodeAndStatus(code);

        Participant participant = mappingParticipant(user, room);
        participantRepository.save(participant);
    }

    @Override
    @Transactional
    public StartRoomDto start(User user, String code) {

        Room room = checkRoomCode(code);
        validateChief(user, room);
        room.setStatus(IN_PROGRESS);

        return StartRoomDto.builder()
                .name(room.getName())
                .status(room.getStatus())
                .build();
    }


    private void validateChief(User user, Room room) {
        if (!room.getUser().getId().equals(user.getId())) {
            throw new IllegalArgumentException("권한이 없는 방입니다.");
        }
    }

    private Room checkRoomCode(String code) {
        return roomRepository.findByCode(code)
                .orElseThrow(() -> new RoomNotFoundException(code));
    }

    private Room checkRoomCodeAndStatus(String code) {
        Room room = checkRoomCode(code);
        if (!STATUS.equals(room.getStatus())) {
            throw new InvalidRoomForParticipateException(FORBIDDEN_STATUS + room.getStatus());
        }
        return room;
    }

    private String createAccountNum() {
        String accountNum = Long.toString(ThreadLocalRandom.current().nextLong(1000L, 9999L));
        while (roomRepository.findByCode(accountNum).isPresent()) {
            accountNum = Long.toString(ThreadLocalRandom.current().nextLong(1000L, 9999L));
        }
        return accountNum;
    }

    private List<Question> mappingQuestion(List<RequestQuestion> questionsList, Room room) {
        return questionsList.stream()
                .map(reqQuestion -> Question.builder()
                        .questionNum(reqQuestion.getQuestion_num())
                        .questionContent(reqQuestion.getQuestion_content())
                        .prizeName(reqQuestion.getPrize_name())
                        .prizeContent(reqQuestion.getPrize_content())
                        .room(room) // Room 설정
                        .build())
                .toList();
    }

    private Participant mappingParticipant(User user, Room room) {
        return Participant.builder()
                .user(user)
                .room(room)
                .build();
    }

    @Override
    public List<ParticipantDto> getParticipants(String code) {
        Room room = checkRoomCode(code);
        List<Participant> participants = participantRepository.findByRoomId(room.getId());

        return participants.stream()
                .map(ParticipantDto::fromEntity)
                .toList();
    }
}