package com.nexus.nexusrpg.domain.user.validator;

import com.nexus.nexusrpg.core.exception.BusinessException;
import com.nexus.nexusrpg.domain.user.model.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserValidator {

    public void hasEnoughOxygen(User user) {

        if (user.getOxygen() <= 0) {
            throw new BusinessException("User", "Não possui oxigênio suficiente", HttpStatus.BAD_REQUEST);
        }
    }
}
