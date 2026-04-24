package com.nexus.nexusrpg.user.service;

import com.nexus.nexusrpg.user.model.User;
import com.nexus.nexusrpg.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserInitService userInitService;
    private final UserRepository userRepository;

    @Transactional
    public void createUser(
            String username,
            String email,
            String password
    ){
        var level = userInitService.initialLevel();

        var user = User.builder()
                .username(username)
                .email(email)
                .password(password)
                .level(level)
                .build();

        userRepository.save(user);
        userInitService.initialize(user);
    }

    public User findByEmail(String email) {
        return userRepository.findByEmailOrThrow(email);
    }
}
