package com.ganggun.petition94.domain.auth.presentation.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequest {

    @NotBlank
    private String loginId;

    @NotBlank
    private String password;
}
