package com.neordinary.backend.domain.participant.dto;

import com.neordinary.backend.domain.participant.entity.Participant;
import lombok.Data;

@Data
public class ParticipantDto {
	private String name;

	public static ParticipantDto fromEntity(Participant participant) {
		ParticipantDto participantDto = new ParticipantDto();
		participantDto.setName(participant.getUser().getName());
		return participantDto;
	}
}