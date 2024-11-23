package com.neordinary.backend.domain.participant.dto;

import com.neordinary.backend.domain.participant.entity.Participant;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ParticipantDto {
	private String name;

	private String email;

	public static ParticipantDto fromEntity(Participant participant) {
		return ParticipantDto.builder()
				.name(participant.getUser().getName())
				.email(participant.getUser().getEmail())
				.build();
	}
}