package com.neordinary.backend.global.jwt.exception;

import com.neordinary.backend.global.exception.BaseException;
import org.springframework.http.HttpStatus;


public class InvalidJwtException extends BaseException {
    public InvalidJwtException(String message) {
        super(HttpStatus.UNAUTHORIZED, message);
    }
}