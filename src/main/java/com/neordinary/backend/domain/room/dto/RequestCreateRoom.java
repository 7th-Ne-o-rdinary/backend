package com.neordinary.backend.domain.room.dto;

import com.neordinary.backend.domain.question.dto.RequestQuestion;
import com.neordinary.backend.domain.room.entity.Room;
import lombok.Getter;

import java.util.List;


@Getter
public class RequestCreateRoom {

    private static final String STATUS = "시작 전";

    private String name;
    private List<RequestQuestion> questions;

    public Room toEntity() {
        return Room.builder()
                .name(name)
                .status(STATUS)
                .build();
    }
}