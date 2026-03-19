package com.nexus.nexusrpg.service;

import com.nexus.nexusrpg.controller.dto.UserDTO;
import com.nexus.nexusrpg.controller.dto.request.LoginRequestDTO;
import com.nexus.nexusrpg.controller.dto.request.RegisterRequestDTO;
import com.nexus.nexusrpg.controller.dto.response.LoginResponseDTO;
import com.nexus.nexusrpg.exception.BusinessException;
import com.nexus.nexusrpg.mapper.UserMapper;
import com.nexus.nexusrpg.model.entity.Level;
import com.nexus.nexusrpg.model.entity.Mission;
import com.nexus.nexusrpg.model.entity.Planet;
import com.nexus.nexusrpg.model.entity.User;
import com.nexus.nexusrpg.repository.LevelRepository;
import com.nexus.nexusrpg.repository.MissionRepository;
import com.nexus.nexusrpg.repository.PlanetRepository;
import com.nexus.nexusrpg.repository.UserRepository;
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

@RequiredArgsConstructor
@Service
public class AuthService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final AuthValidator authValidator;

    private final LevelRepository levelRepository;
    private final PlanetRepository planetRepository;
    private final MissionRepository missionRepository;

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

    public UserDTO getMe() {

        String email = SecurityContextHolder.getContext().getAuthentication().getName();

        User me = userRepository.findByEmailOrThrow(email);

        return userMapper.toDTO(me);
    }

    private void setUpNewRegister(User user){
        Level level = levelRepository.findById(1L)
                .orElseThrow(() -> new BusinessException("Level", "Nenhum level encontrado", HttpStatus.BAD_REQUEST));

        Planet planet = planetRepository.findById(1L)
                .orElseThrow(() -> new BusinessException("Planet", "Nenhum planeta encontrado", HttpStatus.BAD_REQUEST));

        Mission mission = missionRepository.findById(1L)
                .orElseThrow(() -> new BusinessException("Mission", "Nenhuma missão encontrada", HttpStatus.BAD_REQUEST));

        user.setLevel(level);
        user.setCurrentPlanet(planet);
        user.addUnlockedPlanet(planet);
        user.setCurrentMission(mission);
        user.addUnlockedMission(mission);
    }
}
