package com.nexus.nexusrpg.domain.user.service;

import com.nexus.nexusrpg.domain.user.controller.dto.UserDTO;
import com.nexus.nexusrpg.domain.user.mapper.UserMapper;
import com.nexus.nexusrpg.domain.user.model.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserFacade {

    private final UserService userService;
    private final UserMapper userMapper;

    public User getAuthenticatedUser() {

        String authenticatedEmail = SecurityContextHolder.getContext().getAuthentication().getName();
        return userService.findByEmail(authenticatedEmail);
    }

    public UserDTO getAuthenticatedUserDTO() {

        return userMapper.toDTO(getAuthenticatedUser());
    }
}
