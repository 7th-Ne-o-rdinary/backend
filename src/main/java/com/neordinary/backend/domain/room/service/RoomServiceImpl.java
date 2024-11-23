package com.neordinary.backend.domain.room.service;

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

    @Override
    public String create(User user, RequestCreateRoom requestCreateRoom) {
        Room room = requestCreateRoom.toEntity();
        room.setCode(createAccountNum());
        room.setUser(user);
        roomRepository.save(room);

        List<Question> questions = requestCreateRoom.getQuestions();
        questions.forEach(question -> question.setRoom(room));
        questionRepository.saveAll(requestCreateRoom.getQuestions());

        return room.getCode();
    }

    private String createAccountNum() {
        return Long.toString(ThreadLocalRandom.current().nextLong(100000L, 900000L));
    }
}