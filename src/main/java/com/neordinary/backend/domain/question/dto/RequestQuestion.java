package com.neordinary.backend.domain.question.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Getter;

@Getter
public class RequestQuestion {
    @Positive
    @Schema(description = "질문 번호", example = "1")
    private Integer question_num;

    @NotBlank
    @Schema(description = "질문 내용", example = "UMC 최고 개그맨은?")
    private String question_content;

    @NotBlank
    @Schema(description = "상품명", example = "UMC 최고 개그맨")
    private String prize_name;

    @NotBlank
    @Schema(description = "상품 내용", example = "UMC 최고 개그맨으로 인정합니다.")
    private String prize_content;
}