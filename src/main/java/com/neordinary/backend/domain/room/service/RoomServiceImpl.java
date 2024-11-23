package com.neordinary.backend.domain.room.service;

import com.neordinary.backend.domain.participant.entity.Participant;
import com.neordinary.backend.domain.participant.repository.ParticipantRepository;
import com.neordinary.backend.domain.question.dto.RequestQuestion;
import com.neordinary.backend.domain.question.entity.Question;
import com.neordinary.backend.domain.question.repository.QuestionRepository;
import com.neordinary.backend.domain.room.dto.RequestCreateRoom;
import com.neordinary.backend.domain.room.entity.Room;
import com.neordinary.backend.domain.room.repository.RoomRepository;
import com.neordinary.backend.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepository;
    private final QuestionRepository questionRepository;
    private final ParticipantRepository participantRepository;

    @Override
    public String create(User user, RequestCreateRoom requestCreateRoom) {

        Room room = requestCreateRoom.toEntity();
        room.setCode(createAccountNum());
        room.setUser(user);
        roomRepository.save(room);

        List<Question> questions = mappingQuestion(requestCreateRoom.getQuestions(), room);
        questionRepository.saveAll(questions);

        return room.getCode();
    }

    @Override
    public void join(User user, String code) {

        Room room = checkRoomCode(code);
        Participant participant = mappingParticipant(user, room);
        participantRepository.save(participant);
    }

    private String createAccountNum() {
        return Long.toString(ThreadLocalRandom.current().nextLong(100000L, 900000L));
    }

    private Room checkRoomCode(String code) {
        return roomRepository.findByCode(code)
                .orElseThrow(() -> new IllegalArgumentException("유요하지 않은 코드: " + code));
    }

    private List<Question> mappingQuestion(List<RequestQuestion> questionsList, Room room) {
        return questionsList.stream()
                .map(reqQuestion -> Question.builder()
                        .question_num(reqQuestion.getQuestion_num())
                        .question_content(reqQuestion.getQuestion_content())
                        .prize_name(reqQuestion.getPrize_name())
                        .prize_content(reqQuestion.getPrize_content())
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
}