package com.nexus.nexusrpg.domain.user.service;

import com.nexus.nexusrpg.common.init.InitApplication;
import com.nexus.nexusrpg.domain.user.model.User;
import com.nexus.nexusrpg.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final InitApplication initApplication;
    private final UserRepository userRepository;

    public void createUser(
            String username,
            String email,
            String password
    ){
        var level = initApplication.initialLevel();

        var user = User.builder()
                .username(username)
                .email(email)
                .password(password)
                .level(level)
                .build();

        userRepository.save(user);
        initApplication.initUser(user);
    }

    public User findByEmail(String email) {
        return userRepository.findByEmailOrThrow(email);
    }
}
