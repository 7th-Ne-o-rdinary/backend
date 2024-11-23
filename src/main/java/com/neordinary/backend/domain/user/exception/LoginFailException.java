package com.neordinary.backend.domain.user.exception;

import com.neordinary.backend.global.exception.BaseException;
import org.springframework.http.HttpStatus;

public class LoginFailException extends BaseException {
    public LoginFailException() {
        super(HttpStatus.BAD_REQUEST, "로그인에 실패했습니다.");
    }
}