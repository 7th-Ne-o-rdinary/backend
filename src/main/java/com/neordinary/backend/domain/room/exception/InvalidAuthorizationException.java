package com.neordinary.backend.domain.room.exception;

import com.neordinary.backend.global.exception.BaseException;
import org.springframework.http.HttpStatus;

public class InvalidAuthorizationException extends BaseException {
	public InvalidAuthorizationException() {
		super(HttpStatus.FORBIDDEN, "권한이 없습니다.");
	}
}