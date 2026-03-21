package com.nexus.nexusrpg.domain.auth.service;

import com.nexus.nexusrpg.domain.auth.controller.dto.request.LoginRequestDTO;
import com.nexus.nexusrpg.domain.auth.controller.dto.request.RegisterRequestDTO;
import com.nexus.nexusrpg.domain.auth.controller.dto.response.LoginResponseDTO;
import com.nexus.nexusrpg.domain.user.repository.entity.UserRepository;
import com.nexus.nexusrpg.domain.user.model.entity.User;
import com.nexus.nexusrpg.domain.auth.validator.AuthValidator;
import lombok.RequiredArgsConstructor;
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

    private final SetUpService setUpService;

    private final AuthValidator authValidator;

    private final UserRepository userRepository;

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
                .issuer("dto")
                .subject(me.getEmail())
                .issuedAt(now)
                .expiresAt(now.plusSeconds(expiresIn))
                .build();

        String accessToken = jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();

        return new LoginResponseDTO(accessToken, expiresIn, now);
    }

    private void setUpNewRegister(User user) {

        setUpService.setUpInitialLevel(user);
        setUpService.setUpInitialUserPlanets(user);
        setUpService.setUpInitialUserMissions(user);
        setUpService.setUpInitialUserResources(user);
    }

    public String getAuthenticatedEmail() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }

    public User getAuthenticatedUser() {
        return userRepository.findByEmailOrThrow(getAuthenticatedEmail());
    }
}
