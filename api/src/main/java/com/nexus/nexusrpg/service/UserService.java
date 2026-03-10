package com.nexus.nexusrpg.service;

import com.nexus.nexusrpg.controller.dto.response.UserResponseDTO;
import com.nexus.nexusrpg.mapper.UserMeMapper;
import com.nexus.nexusrpg.model.entity.User;
import com.nexus.nexusrpg.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;
    private final UserMeMapper userMeMapper;

    public UserResponseDTO getMe() {

        String email = SecurityContextHolder.getContext().getAuthentication().getName();

        User user = userRepository.findByEmailWithStatsOrThrow(email);

        return userMeMapper.toResponse(user);
    }
}