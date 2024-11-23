package com.neordinary.backend.domain.user.exception;

import com.neordinary.backend.global.exception.BaseException;
import org.springframework.http.HttpStatus;

public class UserCreateValidationException extends BaseException {
    public UserCreateValidationException() {
        super(HttpStatus.CONFLICT, "가입 시 중복된 정보가 있습니다.");
    }
}