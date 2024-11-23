package com.neordinary.backend.domain.room.exception;

import com.neordinary.backend.global.exception.BaseException;
import org.springframework.http.HttpStatus;

public class InvalidRoomForStartException extends BaseException {
	public InvalidRoomForStartException(String status) {
		super(HttpStatus.BAD_REQUEST, "방을 시작할 수 없는 상태입니다: " + status);
	}
}