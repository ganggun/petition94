package com.ganggun.petition94.domain.reaction.error;

import com.ganggun.petition94.global.exception.CustomError;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ReactionError implements CustomError {
    REACTION_ALREADY_EXIST(HttpStatus.BAD_REQUEST, "이미 반응한 청원입니다.");

    private final HttpStatus status;
    private final String message;
}
