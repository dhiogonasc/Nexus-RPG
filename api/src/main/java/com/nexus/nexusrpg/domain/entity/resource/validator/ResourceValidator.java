package com.nexus.nexusrpg.domain.entity.resource.validator;

import com.nexus.nexusrpg.core.exception.BusinessException;
import com.nexus.nexusrpg.domain.model.relation.UResource;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import static com.nexus.nexusrpg.common.entity.enums.EntityStatus.COMPLETED;
import static org.springframework.http.HttpStatus.CONFLICT;

@RequiredArgsConstructor
@Component
public class ResourceValidator {

    public void isCollectable(UResource resource) {

        var resourceStatus = resource.getExecution().getStatus();

        if (resourceStatus == COMPLETED) {
            throw new BusinessException(
                    "Resource",
                    "Este recurso já foi extraído.",
                    CONFLICT
            );
        }
    }
}
