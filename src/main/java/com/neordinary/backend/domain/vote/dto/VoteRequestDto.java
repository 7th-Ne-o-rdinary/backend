package com.neordinary.backend.domain.vote.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VoteRequestDto {
	@Getter
	@Setter
	public static class createVoteDto{
		@Schema(example="user02@email.com")
		@NotBlank
		private String votedPeopleEmail;

		@Schema(example= "1")
		@NotBlank
		private Long questionId;


	}
}
