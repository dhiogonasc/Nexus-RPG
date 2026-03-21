package com.nexus.nexusrpg.domain.auth.validator.email;

import com.nexus.nexusrpg.domain.user.repository.entity.UserRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmailUnicoValidator implements ConstraintValidator<EmailUnico, String> {

    private final UserRepository userRepository;

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        if (email == null || email.isEmpty()) return true;
        return !userRepository.existsByEmail(email);
    }
}