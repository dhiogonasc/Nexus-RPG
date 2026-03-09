package com.nexus.nexusrpg.validator;

import com.nexus.nexusrpg.repository.UsuarioRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmailUnicoValidator implements ConstraintValidator<EmailUnico, String> {

    private UsuarioRepository usuarioRepository;

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        if (email == null || email.isEmpty()) return true;
        return !usuarioRepository.existsByEmail(email);
    }
}