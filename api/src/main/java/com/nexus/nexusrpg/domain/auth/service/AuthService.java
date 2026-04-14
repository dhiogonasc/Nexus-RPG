package com.nexus.nexusrpg.domain.auth.service;

import com.nexus.nexusrpg.common.service.InitApplicationService;
import com.nexus.nexusrpg.domain.auth.controller.dto.request.LoginRequestDTO;
import com.nexus.nexusrpg.domain.auth.controller.dto.request.RegisterRequestDTO;
import com.nexus.nexusrpg.domain.auth.controller.dto.response.LoginResponseDTO;
import com.nexus.nexusrpg.domain.user.repository.entity.UserRepository;
import com.nexus.nexusrpg.domain.user.model.entity.User;
import com.nexus.nexusrpg.domain.auth.validator.AuthValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

@RequiredArgsConstructor
@Service
public class AuthService {

    private final InitApplicationService initApplicationService;
    private final AuthValidator authValidator;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtEncoder jwtEncoder;

    @Transactional
    public void register(RegisterRequestDTO request) {

        var user = User.builder()
                .username(request.username())
                .email(request.email())
                .password(passwordEncoder.encode(request.password()))
                .build();

        initApplicationService.initUser(user);
        userRepository.save(user);
    }

    public LoginResponseDTO login(LoginRequestDTO request) {

        var user = userRepository.findByEmailOrThrow(request.email());

        authValidator.validatePassword(request.password(), user.getPassword());

        var expiresIn = 3600L;
        var loggedInAt = Instant.now();

        var claims = JwtClaimsSet.builder()
                .issuer("dto")
                .subject(user.getEmail())
                .issuedAt(loggedInAt)
                .expiresAt(loggedInAt.plusSeconds(expiresIn))
                .build();

        String accessToken = jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();

        return new LoginResponseDTO(
                accessToken,
                expiresIn,
                loggedInAt
        );
    }

    public User getAuthenticatedUser() {

        String authenticatedEmail = SecurityContextHolder.getContext().getAuthentication().getName();
        return userRepository.findByEmailOrThrow(authenticatedEmail);
    }
}
