package com.ganggun.petition94.domain.auth.presentation.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JoinRequest {

    @NotBlank
    private String loginId;

    @NotBlank
    private String nickname;

    @NotBlank
    private String password;

    @NotBlank
    private String passwordCheck;
}

