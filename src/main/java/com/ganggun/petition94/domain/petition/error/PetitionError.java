package com.ganggun.petition94.domain.petition.error;

import com.ganggun.petition94.global.exception.CustomError;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum PetitionError implements CustomError {
    PETITION_NOT_FOUND(HttpStatus.NOT_FOUND, "청원을 찾을 수 없습니다.");

    private final HttpStatus status;
    private final String message;
}
