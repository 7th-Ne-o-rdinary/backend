package com.neordinary.backend.domain.room.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RoomCodeDto {
	@Schema(description = "방 코드", example = "1234")
	private String code;
}