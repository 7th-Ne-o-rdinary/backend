package com.neordinary.backend.domain.room.exception;

import com.neordinary.backend.global.exception.BaseException;
import org.springframework.http.HttpStatus;

public class RoomNotFoundException extends BaseException {
	public RoomNotFoundException(String code) {
		super(HttpStatus.NOT_FOUND, code + " 방을 찾을 수 없습니다.");
	}
}