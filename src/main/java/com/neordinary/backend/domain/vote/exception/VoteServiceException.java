package com.neordinary.backend.domain.vote.exception;

import org.springframework.http.HttpStatus;

import com.neordinary.backend.global.exception.BaseException;

public class VoteServiceException extends BaseException {
	public VoteServiceException(){
		super(HttpStatus.NOT_FOUND, "투표 결과가 존재하지 않습니다.");
	}
}
