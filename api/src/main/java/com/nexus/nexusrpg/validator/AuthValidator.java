package com.nexus.nexusrpg.validator;

import com.nexus.nexusrpg.exception.BusinessException;
import com.nexus.nexusrpg.model.entity.User;
import com.nexus.nexusrpg.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import static org.springframework.http.HttpStatus.*;

@RequiredArgsConstructor
@Component
public class AuthValidator {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder;

    public void validateEmailExists(String email) {

        if(userRepository.existsByEmail(email)){
            throw new BusinessException("email", "Email já cadastrado", CONFLICT);
        }
    }

    public User validateEmailRegistered(String email) {

        return userRepository.findByEmail(email)
                .orElseThrow(() -> new BusinessException("auth", "Usuário ou senha incorretos", BAD_REQUEST));
    }

    public void validatePassword(String password, String hash) {

        if (!encoder.matches(password, hash)) {
            throw new BusinessException("auth", "Usuário ou senha incorretos", BAD_REQUEST);
        }
    }
}
