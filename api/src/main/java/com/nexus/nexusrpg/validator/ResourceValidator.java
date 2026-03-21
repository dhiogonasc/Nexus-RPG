package com.nexus.nexusrpg.validator;

import com.nexus.nexusrpg.core.exception.BusinessException;
import com.nexus.nexusrpg.model.entity.Resource;
import com.nexus.nexusrpg.domain.user.model.entity.User;
import com.nexus.nexusrpg.model.enums.EntityStatus;
import com.nexus.nexusrpg.domain.user.model.relation.UserPlanet;
import com.nexus.nexusrpg.domain.user.model.relation.UserResource;
import com.nexus.nexusrpg.domain.user.repository.relation.UserPlanetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ResourceValidator {

    private final UserPlanetRepository userPlanetRepository;

    public void isCollectable(UserResource userResource) {

        User user = userResource.getUser();
        Resource resource = userResource.getResource();

        if (user == null || resource == null || resource.getPlanet() == null) {
            throw new BusinessException("Data", "Dados de vínculo incompletos.", HttpStatus.BAD_REQUEST);
        }

        UserPlanet userPlanet = userPlanetRepository.findByUserIdAndPlanetIdOrThrow(
                user.getId(),
                resource.getPlanet().getId()
        );

        if (userPlanet.getStatus() != EntityStatus.COMPLETED) {
            throw new BusinessException("Planet", "Acesso negado: complete o planeta primeiro!", HttpStatus.FORBIDDEN);
        }

        if (userResource.isCollected()) {
            throw new BusinessException("Resource", "Este recurso já foi extraído.", HttpStatus.CONFLICT);
        }
    }
}
