package com.nexus.nexusrpg.service;

import com.nexus.nexusrpg.controller.dto.mission.UserMissionDTO;
import com.nexus.nexusrpg.controller.dto.planet.UserPlanetDTO;
import com.nexus.nexusrpg.exception.BusinessException;
import com.nexus.nexusrpg.mapper.UserMapper;
import com.nexus.nexusrpg.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserMapper userMapper;
    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public List<UserPlanetDTO> getPlanets() {
        String email = getAuthenticatedEmail();

        return userRepository.findByEmailWithPlanets(email)
                .map(user -> user.getPlanets().stream()
                        .map(userMapper::toUserPlanetDTO)
                        .toList())
                .orElseThrow(() -> new BusinessException("User", "Usuário não encontrado", HttpStatus.NOT_FOUND));
    }

    @Transactional(readOnly = true)
    public List<UserMissionDTO> getMissions() {
        String email = getAuthenticatedEmail();

        return userRepository.findByEmailWithMissions(email)
                .map(user -> user.getMissions().stream()
                        .map(userMapper::toUserMissionDTO)
                        .toList())
                .orElseThrow(() -> new BusinessException("User", "Usuário não encontrado", HttpStatus.NOT_FOUND));
    }

    private String getAuthenticatedEmail() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }
}
