package com.nexus.nexusrpg.service;

import com.nexus.nexusrpg.controller.dto.UserProfileDTO;
import com.nexus.nexusrpg.mapper.UserProfileMapper;
import com.nexus.nexusrpg.model.relation.UserProfile;
import com.nexus.nexusrpg.repository.UserProfileRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserProfileService {

    private final UserProfileRepository userProfileRepository;
    private final UserProfileMapper userProfileMapper;

    public UserProfileDTO getMe() {

        String email = SecurityContextHolder.getContext().getAuthentication().getName();

        UserProfile user = userProfileRepository.findByUserEmailOrThrow(email);

        return userProfileMapper.toDTO(user);
    }
}