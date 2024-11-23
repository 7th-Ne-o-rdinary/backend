package com.neordinary.backend.domain.user.exception;

import com.neordinary.backend.global.exception.BaseException;
import org.springframework.http.HttpStatus;

public class PasswordCheckNotMatchException extends BaseException {
    public PasswordCheckNotMatchException() {
        super(HttpStatus.BAD_REQUEST, "비밀번호가 일치하지 않습니다.");
    }
}