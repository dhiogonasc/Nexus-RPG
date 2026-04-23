package com.nexus.nexusrpg.core.auth.validator.email;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = RegisterInputValidator.class)
public @interface UniqueEmail {
    String message() default "Este e-mail já está cadastrado";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}