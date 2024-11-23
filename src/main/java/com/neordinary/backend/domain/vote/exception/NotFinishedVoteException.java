package com.neordinary.backend.domain.vote.exception;

import com.neordinary.backend.global.exception.BaseException;
import org.springframework.http.HttpStatus;

public class NotFinishedVoteException extends BaseException {
	public NotFinishedVoteException() {
		super(HttpStatus.BAD_REQUEST, "투표가 종료되지 않았습니다.");
	}
}