package com.nexus.nexusrpg.user.validator;

import com.nexus.nexusrpg.core.exception.BusinessException;
import com.nexus.nexusrpg.user.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Component
@RequiredArgsConstructor
public class UserValidator {

    public void hasEnoughOxygen(User user) {
        if (user.getOxygen() <= 0) {
            throw new BusinessException(
                    "User",
                    "Não possui oxigênio suficiente",
                    BAD_REQUEST
            );
        }
    }
}
