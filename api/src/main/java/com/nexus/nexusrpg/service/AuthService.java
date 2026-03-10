package com.nexus.nexusrpg.service;

import com.nexus.nexusrpg.controller.dto.request.LoginRequestDTO;
import com.nexus.nexusrpg.controller.dto.request.RegisterRequestDTO;
import com.nexus.nexusrpg.controller.dto.response.LoginResponseDTO;
import com.nexus.nexusrpg.controller.dto.response.RegisterResponseDTO;
import com.nexus.nexusrpg.mapper.AuthMapper;
import com.nexus.nexusrpg.model.entity.User;
import com.nexus.nexusrpg.repository.UserRepository;
import com.nexus.nexusrpg.security.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;
    private final PasswordEncoder passwordEncoder;

    private final AuthMapper authMapper;

    private final UserRepository userRepository;

    public LoginResponseDTO auth(LoginRequestDTO dto) {

        UsernamePasswordAuthenticationToken authToken =
                new UsernamePasswordAuthenticationToken(dto.email(), dto.password());

        Authentication auth = authenticationManager.authenticate(authToken);
        LocalDateTime loggedInAt = LocalDateTime.now();

        return new LoginResponseDTO(
                tokenService.gerarToken(auth.getName()),
                loggedInAt
        );
    }

    public RegisterResponseDTO create(RegisterRequestDTO dto) {

        User user = authMapper.toEntity(dto);

        user.setPassword(passwordEncoder.encode(dto.password()));

        return authMapper.toResponse(userRepository.save(user));
    }
}