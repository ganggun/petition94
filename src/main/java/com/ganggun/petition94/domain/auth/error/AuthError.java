package com.ganggun.petition94.domain.auth.error;

import com.ganggun.petition94.global.exception.CustomError;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum AuthError implements CustomError {
    LOGIN_ID_DUPLICATE(HttpStatus.BAD_REQUEST,"로그인 아이디가 중복됩니다"),
    NICKNAME_DUPLICATE(HttpStatus.BAD_REQUEST,"닉네임이 중복됩니다"),      // 닉네임 중복
    PASSWORD_MISMATCH(HttpStatus.BAD_REQUEST,"체킹 비밀번호가 입력한 비밀번호와 일치하지 않습니다"),
    INVALID_CREDENTIALS_MESSAGE(HttpStatus.UNAUTHORIZED,"아이디 또는 비밀번호가 일치하지 않습니다"),
    LOGIN_REQUIRED_MESSAGE(HttpStatus.UNAUTHORIZED,"로그인이 필요합니다");


    private final HttpStatus status;
    private final String message;
}

