package com.nexus.nexusrpg.service;

import com.nexus.nexusrpg.controller.dto.request.LoginRequestDTO;
import com.nexus.nexusrpg.controller.dto.request.RegisterRequestDTO;
import com.nexus.nexusrpg.controller.dto.response.LoginResponseDTO;
import com.nexus.nexusrpg.controller.dto.response.RegisterResponseDTO;
import com.nexus.nexusrpg.mapper.AuthMapper;
import com.nexus.nexusrpg.model.entity.Level;
import com.nexus.nexusrpg.model.entity.User;
import com.nexus.nexusrpg.model.relation.UserStat;
import com.nexus.nexusrpg.repository.LevelRepository;
import com.nexus.nexusrpg.repository.UserRepository;
import com.nexus.nexusrpg.repository.UserStatRepository;
import com.nexus.nexusrpg.security.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Transactional
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;
    private final PasswordEncoder passwordEncoder;

    private final AuthMapper authMapper;

    private final UserRepository userRepository;
    private final UserStatRepository userStatRepository;
    private final LevelRepository levelRepository;

    public LoginResponseDTO auth(LoginRequestDTO dto) {

        UsernamePasswordAuthenticationToken authToken =
                new UsernamePasswordAuthenticationToken(dto.email(), dto.password());

        Authentication auth = authenticationManager.authenticate(authToken);
        LocalDateTime loggedInAt = LocalDateTime.now();

        UserStat stats = userStatRepository.findByUserEmailOrThrow(dto.email());
        stats.setLastAccess(loggedInAt);

        userStatRepository.save(stats);

        return new LoginResponseDTO(
                tokenService.gerarToken(auth.getName()),
                loggedInAt
        );
    }

    public RegisterResponseDTO create(RegisterRequestDTO dto) {

        User user = authMapper.toEntity(dto);
        user.setPassword(passwordEncoder.encode(dto.password()));

        userRepository.save(user);

        Level level = levelRepository.findByNumberOrThrow(1);

        UserStat userStat = UserStat.builder()
                .user(user)
                .level(level)
                .build();

        userStatRepository.save(userStat);

        return authMapper.toResponse(user);
    }
}