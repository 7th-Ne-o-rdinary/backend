package com.neordinary.backend.domain.room.dto;

import com.neordinary.backend.domain.question.dto.RequestQuestion;
import com.neordinary.backend.domain.room.entity.Room;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

import java.util.List;


@Getter
public class RequestCreateRoom {

    private static final String STATUS = "시작 전";

    @NotBlank
    @Schema(description = "시상식 명", example = "2024년 연말 UMC 시상식")
    private String name;

    private List<RequestQuestion> questions;

    public Room toEntity() {
        return Room.builder()
                .name(name)
                .status(STATUS)
                .build();
    }
}