package com.neordinary.backend.domain.user.exception;

import com.neordinary.backend.global.exception.BaseException;
import org.springframework.http.HttpStatus;

public class InvalidRefreshTokenException extends BaseException {
    public InvalidRefreshTokenException() {
        super(HttpStatus.BAD_REQUEST, "유효하지 않은 리프레시 토큰입니다.");
    }
}