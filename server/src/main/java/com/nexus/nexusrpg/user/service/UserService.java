package com.nexus.nexusrpg.user.service;

import com.nexus.nexusrpg.user.model.User;
import com.nexus.nexusrpg.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final InitUser initUser;
    private final UserRepository userRepository;

    public void createUser(
            String username,
            String email,
            String password
    ){
        var level = initUser.initialLevel();

        var user = User.builder()
                .username(username)
                .email(email)
                .password(password)
                .level(level)
                .build();

        userRepository.save(user);
        initUser.initialize(user);
    }

    public User findByEmail(String email) {
        return userRepository.findByEmailOrThrow(email);
    }
}
