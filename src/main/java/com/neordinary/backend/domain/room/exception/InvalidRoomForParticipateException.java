package com.neordinary.backend.domain.room.exception;

import com.neordinary.backend.global.exception.BaseException;
import org.springframework.http.HttpStatus;

public class InvalidRoomForParticipateException extends BaseException {
	public InvalidRoomForParticipateException(String status) {
		super(HttpStatus.BAD_REQUEST, "방에 참여할 수 없는 상태입니다: " + status);
	}
}