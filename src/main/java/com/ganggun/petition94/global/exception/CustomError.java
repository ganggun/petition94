package com.ganggun.petition94.global.exception;

import org.springframework.http.HttpStatus;

public interface CustomError {
    HttpStatus getStatus();
    String getMessage();
}
