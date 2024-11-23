package com.neordinary.backend.domain.question.dto;

import lombok.Getter;

@Getter
public class RequestQuestion {

    private Integer question_num;
    private String question_content;
    private String prize_name;
    private String prize_content;
}