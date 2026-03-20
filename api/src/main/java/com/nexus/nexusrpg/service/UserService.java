package com.nexus.nexusrpg.service;

import com.nexus.nexusrpg.controller.dto.mission.UserMissionReferenceDTO;
import com.nexus.nexusrpg.controller.dto.planet.UserPlanetReferenceDTO;
import com.nexus.nexusrpg.exception.BusinessException;
import com.nexus.nexusrpg.mapper.UserMapper;
import com.nexus.nexusrpg.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final AuthService authService;
    private final UserMapper userMapper;
    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public List<UserPlanetReferenceDTO> getPlanets() {
        String email = authService.getAuthenticatedEmail();

        return userRepository.findByEmailWithPlanets(email)
                .map(user -> user.getPlanets().stream()
                        .map(userMapper::toUserPlanetReferenceDTO)
                        .toList())
                .orElseThrow(() -> new BusinessException("User", "Usuário não encontrado", HttpStatus.NOT_FOUND));
    }

    @Transactional(readOnly = true)
    public List<UserMissionReferenceDTO> getMissions() {
        String email = authService.getAuthenticatedEmail();

        return userRepository.findByEmailWithMissions(email)
                .map(user -> user.getMissions().stream()
                        .map(userMapper::toUserMissionReferenceDTO)
                        .toList())
                .orElseThrow(() -> new BusinessException("User", "Usuário não encontrado", HttpStatus.NOT_FOUND));
    }
}
