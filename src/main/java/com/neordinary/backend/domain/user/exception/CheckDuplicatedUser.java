package com.neordinary.backend.domain.user.exception;

import com.neordinary.backend.global.exception.BaseException;
import org.springframework.http.HttpStatus;

public class CheckDuplicatedUser extends BaseException {

    public CheckDuplicatedUser() {
        super(HttpStatus.CONFLICT, "이미 참가한 사용자입니다.");
    }
}