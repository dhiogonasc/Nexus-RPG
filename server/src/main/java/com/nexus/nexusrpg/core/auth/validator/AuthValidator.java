package com.nexus.nexusrpg.core.auth.validator;

import com.nexus.nexusrpg.core.exception.BusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import static org.springframework.http.HttpStatus.*;

@Component
@RequiredArgsConstructor
public class AuthValidator {

    private final PasswordEncoder encoder;

    public void validatePassword(String password, String hash) {

        if (!encoder.matches(password, hash)) {
            throw new BusinessException("Login", "Usuário ou senha incorretos", BAD_REQUEST);
        }
    }
}
