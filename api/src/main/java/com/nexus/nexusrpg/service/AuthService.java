package com.nexus.nexusrpg.service;

import com.nexus.nexusrpg.controller.dto.UserDTO;
import com.nexus.nexusrpg.controller.dto.request.LoginRequestDTO;
import com.nexus.nexusrpg.controller.dto.request.RegisterRequestDTO;
import com.nexus.nexusrpg.controller.dto.response.LoginResponseDTO;
import com.nexus.nexusrpg.mapper.UserMapper;
import com.nexus.nexusrpg.model.entity.User;
import com.nexus.nexusrpg.repository.UserRepository;
import com.nexus.nexusrpg.validator.AuthValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import java.time.Instant;

@RequiredArgsConstructor
@Service
public class AuthService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final AuthValidator authValidator;

    private final BCryptPasswordEncoder encoder;
    private final JwtEncoder jwtEncoder;

    public void register(RegisterRequestDTO request) {

        User user = User.builder()
                .username(request.username())
                .email(request.email())
                .password(encoder.encode(request.password()))
                .build();

        userRepository.save(user);
    }

    public LoginResponseDTO login(LoginRequestDTO request) {

        User me = userRepository.findByEmailOrThrow(request.email());

        authValidator.validatePassword(request.password(), me.getPassword());

        Instant now = Instant.now();
        long expiresIn = 3600L;

        var claims = JwtClaimsSet.builder()
                .issuer("auth")
                .subject(me.getId().toString())
                .issuedAt(now)
                .expiresAt(now.plusSeconds(expiresIn))
                .build();

        String accessToken = jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();

        return new LoginResponseDTO(accessToken, expiresIn, now);
    }

    public UserDTO getMe() {

        String email = SecurityContextHolder.getContext().getAuthentication().getName();

        User me = userRepository.findByEmailOrThrow(email);

        return userMapper.toDTO(me);
    }
}
