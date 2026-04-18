package com.nexus.nexusrpg.common.context;

import com.nexus.nexusrpg.user.controller.dto.UserDTO;
import com.nexus.nexusrpg.user.model.User;
import com.nexus.nexusrpg.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import static com.nexus.nexusrpg.user.mapper.UserMapper.toDTO;

@Service
@RequiredArgsConstructor
public class Context {

    private final UserService userService;

    public User getAuthenticatedUser() {

        String authenticatedEmail = SecurityContextHolder.getContext().getAuthentication().getName();
        return userService.findByEmail(authenticatedEmail);
    }

    public UserDTO getProfile() {

        return toDTO(getAuthenticatedUser());
    }
}
