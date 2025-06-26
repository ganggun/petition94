package com.ganggun.petition94.domain.auth.presentation;

import com.ganggun.petition94.domain.auth.presentation.dto.JoinRequest;
import com.ganggun.petition94.domain.auth.presentation.dto.LoginRequest;
import com.ganggun.petition94.domain.auth.service.AuthService;
import com.ganggun.petition94.global.common.dto.BaseResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.ganggun.petition94.domain.auth.domain.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final AuthService userService;

    @PostMapping("/join")
    public ResponseEntity<BaseResponse<String>> join(@RequestBody @Valid JoinRequest joinRequest) {
        userService.join(joinRequest);
        return BaseResponse.of("ok");
    }

    @PostMapping("/login")
    public ResponseEntity<BaseResponse<String>> login(@RequestBody LoginRequest loginRequest, HttpServletRequest request) {
        userService.login(loginRequest,request);
        return BaseResponse.of("ok");
    }

    @PostMapping("/logout")
    public ResponseEntity<BaseResponse<String>> logout(HttpServletRequest request) {
        userService.logout(request);
        return BaseResponse.of("ok");
    }

    @GetMapping("/me")
    public ResponseEntity<BaseResponse<User>> me(@SessionAttribute(name = "userId", required = false) Long userId) {
        return BaseResponse.of(userService.getLoginUser(userId));
    }
}

