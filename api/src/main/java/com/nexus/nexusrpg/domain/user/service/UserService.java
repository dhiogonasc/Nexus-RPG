package com.nexus.nexusrpg.domain.user.service;

import com.nexus.nexusrpg.controller.dto.user.UserDTO;
import com.nexus.nexusrpg.domain.user.mapper.UserMapper;
import com.nexus.nexusrpg.domain.user.model.entity.User;
import com.nexus.nexusrpg.domain.user.repository.entity.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserDTO getMe() {

        String email = SecurityContextHolder.getContext().getAuthentication().getName();

        User me = userRepository.findByEmailOrThrow(email);

        return userMapper.toDTO(me);
    }
}
