package com.neordinary.backend.domain.vote.exception;

import org.springframework.http.HttpStatus;

import com.neordinary.backend.global.exception.BaseException;

public class VoteNotFoundException extends BaseException {
	public VoteNotFoundException(){
		super(HttpStatus.NOT_FOUND, "존재하지 않는 참가자입니다.");
	}
}
