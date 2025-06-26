package com.ganggun.petition94.domain.auth.service;

import com.ganggun.petition94.domain.auth.domain.User;
import com.ganggun.petition94.domain.auth.error.AuthError;
import com.ganggun.petition94.domain.auth.presentation.dto.JoinRequest;
import com.ganggun.petition94.domain.auth.presentation.dto.LoginRequest;
import com.ganggun.petition94.domain.auth.domain.repo.UserRepo;
import com.ganggun.petition94.domain.auth.domain.enums.UserRole;
import com.ganggun.petition94.global.exception.CustomException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void join(JoinRequest joinRequest) {
        if (userRepo.existsByLoginId(joinRequest.getLoginId())){
            throw new CustomException(AuthError.LOGIN_ID_DUPLICATE);
        }
        if (userRepo.existsByNickname(joinRequest.getNickname())){
            throw new CustomException(AuthError.NICKNAME_DUPLICATE);
        }
        if (!joinRequest.getPassword().equals(joinRequest.getPasswordCheck())){
            throw new CustomException(AuthError.PASSWORD_MISMATCH);
        }

        User user = User.builder()
                .loginId(joinRequest.getLoginId())
                .nickname(joinRequest.getNickname())
                .password(passwordEncoder.encode(joinRequest.getPassword()))
                .role(UserRole.USER)
                .build();

        userRepo.save(user);
    }

    public void login(LoginRequest loginRequest, HttpServletRequest servletRequest) {

        User user = userRepo.findByLoginId(loginRequest.getLoginId())
                .orElseThrow(() -> new CustomException(AuthError.INVALID_CREDENTIALS_MESSAGE));

        if (!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
            throw new CustomException(AuthError.INVALID_CREDENTIALS_MESSAGE);
        }
        // 기존 세션 무효화 후 새 세션 생성
        servletRequest.getSession().invalidate();
        HttpSession session = servletRequest.getSession(true);
        session.setAttribute("userId", user.getId());
        session.setMaxInactiveInterval(1800); // 30분 세션 유지

    }

    public User getLoginUser(Long userId) {
        if (userId == null) throw new CustomException(AuthError.LOGIN_REQUIRED_MESSAGE);
        return userRepo.findById(userId)
                .orElseThrow(() -> new CustomException(AuthError.LOGIN_REQUIRED_MESSAGE));
    }

    public void logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
    }
}
