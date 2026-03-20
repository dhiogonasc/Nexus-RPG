package com.nexus.nexusrpg.service;

import com.nexus.nexusrpg.controller.dto.request.LoginRequestDTO;
import com.nexus.nexusrpg.controller.dto.request.RegisterRequestDTO;
import com.nexus.nexusrpg.controller.dto.response.LoginResponseDTO;
import com.nexus.nexusrpg.exception.BusinessException;
import com.nexus.nexusrpg.model.entity.Level;
import com.nexus.nexusrpg.model.entity.User;
import com.nexus.nexusrpg.model.enums.EntityStatus;
import com.nexus.nexusrpg.model.relation.UserMission;
import com.nexus.nexusrpg.model.relation.UserPlanet;
import com.nexus.nexusrpg.model.relation.UserResource;
import com.nexus.nexusrpg.repository.*;
import com.nexus.nexusrpg.validator.AuthValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;

@RequiredArgsConstructor
@Service
public class AuthService {

    private final AuthValidator authValidator;

    private final UserRepository userRepository;
    private final LevelRepository levelRepository;
    private final PlanetRepository planetRepository;
    private final MissionRepository missionRepository;
    private final ResourceRepository resourceRepository;

    private final BCryptPasswordEncoder encoder;
    private final JwtEncoder jwtEncoder;

    @Transactional
    public void register(RegisterRequestDTO request) {

        User user = User.builder()
                .username(request.username())
                .email(request.email())
                .password(encoder.encode(request.password()))
                .xp(0)
                .oxygen(10)
                .build();

        setUpNewRegister(user);

        userRepository.save(user);
    }

    public LoginResponseDTO login(LoginRequestDTO request) {

        User me = userRepository.findByEmailOrThrow(request.email());

        authValidator.validatePassword(request.password(), me.getPassword());

        Instant now = Instant.now();
        long expiresIn = 3600L;

        var claims = JwtClaimsSet.builder()
                .issuer("auth")
                .subject(me.getEmail())
                .issuedAt(now)
                .expiresAt(now.plusSeconds(expiresIn))
                .build();

        String accessToken = jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();

        return new LoginResponseDTO(accessToken, expiresIn, now);
    }

    private void setUpNewRegister(User user) {
        Level level = levelRepository.findById(1L)
                .orElseThrow(() -> new BusinessException("Level", "Level 1 não encontrado", HttpStatus.BAD_REQUEST));

        List<UserPlanet> userPlanets = planetRepository.findAll().stream()
                .map(p -> {
                    boolean isFirst = p.getId().equals(1L);
                    return UserPlanet.builder()
                            .user(user)
                            .planet(p)
                            .status(isFirst ? EntityStatus.UNLOCKED : EntityStatus.LOCKED)
                            .isAccessible(isFirst)
                            .build();
                })
                .toList();

        UserPlanet firstUP = userPlanets.stream()
                .filter(up -> up.getPlanet().getId().equals(1L))
                .findFirst()
                .orElseThrow(() -> new BusinessException("Planet", "Planeta 1 não encontrado", HttpStatus.NOT_FOUND));


        List<UserMission> userMissions = missionRepository.findAll().stream()
                .map(m -> {
                    boolean isFirst = m.getId().equals(1L);
                    return UserMission.builder()
                            .user(user)
                            .mission(m)
                            .status(isFirst ? EntityStatus.UNLOCKED : EntityStatus.LOCKED)
                            .isAccessible(isFirst)
                            .build();
                })
                .toList();

        UserMission firstUM = userMissions.stream()
                .filter(um -> um.getMission().getId().equals(1L))
                .findFirst()
                .orElseThrow(() -> new BusinessException("Mission", "Missão 1 não encontrada", HttpStatus.NOT_FOUND));

        List<UserResource> userResources = resourceRepository.findAll().stream()
                .map(r -> UserResource.builder()
                        .user(user)
                        .resource(r)
                        .isCollected(false)
                        .build()
                )
                .toList();

        user.setLevel(level);
        user.setCurrentPlanet(firstUP.getPlanet());
        user.setCurrentMission(firstUM.getMission());

        user.getPlanets().addAll(userPlanets);
        user.getMissions().addAll(userMissions);
        user.getResources().addAll(userResources);
    }

    public String getAuthenticatedEmail() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }

    public User getAuthenticatedUser() {
        return userRepository.findByEmailOrThrow(getAuthenticatedEmail());
    }
}
