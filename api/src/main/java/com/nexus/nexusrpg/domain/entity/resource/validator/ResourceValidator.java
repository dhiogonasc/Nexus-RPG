package com.nexus.nexusrpg.domain.entity.resource.validator;

import com.nexus.nexusrpg.core.exception.BusinessException;
import com.nexus.nexusrpg.domain.entity.resource.model.UserResource;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import static org.springframework.http.HttpStatus.CONFLICT;

@RequiredArgsConstructor
@Component
public class ResourceValidator {

    public void isCollectable(UserResource resource) {

        var resourceStats = resource.getStats();

        if (resourceStats.isCollected()) {
            throw new BusinessException(
                    "Resource",
                    "Este recurso já foi extraído.",
                    CONFLICT
            );
        }
    }
}
