package com.ganggun.petition94.domain.auth.service;

import com.ganggun.petition94.domain.auth.domain.User;
import com.ganggun.petition94.domain.auth.presentation.dto.JoinRequest;
import com.ganggun.petition94.domain.auth.presentation.dto.LoginRequest;
import com.ganggun.petition94.domain.auth.domain.repo.UserRepo;
import com.ganggun.petition94.domain.auth.domain.enums.UserRole;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;

    public boolean checkLoginIdDuplicate(String loginId) {
        return userRepo.existsByLoginId(loginId);
    }

    public boolean checkNicknameDuplicate(String nickname) {
        return userRepo.existsByNickname(nickname);
    }

    @Transactional
    public void join(JoinRequest joinRequest) {
        User user = User.builder()
                .loginId(joinRequest.getLoginId())
                .nickname(joinRequest.getNickname())
                .password(passwordEncoder.encode(joinRequest.getPassword()))
                .role(UserRole.USER)
                .build();

        userRepo.save(user);
    }

    public User login(LoginRequest loginRequest) {
        Optional<User> userOpt = userRepo.findByLoginId(loginRequest.getLoginId());

        if (userOpt.isEmpty()) {
            return null;
        }

        User user = userOpt.get();

        if (!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
            return null;
        }

        return user;
    }

    public User getLoginUser(Long userId) {
        if (userId == null) return null;
        return userRepo.findById(userId).orElse(null);
    }
}
