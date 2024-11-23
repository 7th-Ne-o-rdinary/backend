package com.neordinary.backend.domain.vote.exception;

import org.springframework.http.HttpStatus;

import com.neordinary.backend.global.exception.BaseException;

public class VoteBadRequestException extends BaseException {
	public VoteBadRequestException(){
		super(HttpStatus.BAD_REQUEST, "잘못된 요청입니다.");
	}
}
