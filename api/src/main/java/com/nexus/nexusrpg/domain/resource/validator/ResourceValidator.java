package com.nexus.nexusrpg.domain.resource.validator;

import com.nexus.nexusrpg.core.exception.BusinessException;
import com.nexus.nexusrpg.domain.user.model.relation.UserResource;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ResourceValidator {

    public void isCollectable(UserResource resource) {

        if (resource.isCollected()) {
            throw new BusinessException("Resource", "Este recurso já foi extraído.", HttpStatus.CONFLICT);
        }
    }
}
