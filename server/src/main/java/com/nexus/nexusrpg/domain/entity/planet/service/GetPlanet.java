package com.nexus.nexusrpg.domain.entity.planet.service;

import com.nexus.nexusrpg.common.mapping.mapper.TaskMapper;
import com.nexus.nexusrpg.common.service.GetEntity;
import com.nexus.nexusrpg.domain.controller.dto.planet.UPlanetDTO;
import com.nexus.nexusrpg.domain.controller.dto.planet.UPlanetRDTO;
import com.nexus.nexusrpg.domain.mapper.UPlanetMapper;
import com.nexus.nexusrpg.domain.mapper.reference.UPlanetReferenceMapper;
import com.nexus.nexusrpg.domain.model.Planet;
import com.nexus.nexusrpg.domain.model.relation.UPlanet;
import com.nexus.nexusrpg.domain.repository.relation.UPlanetRepository;
import com.nexus.nexusrpg.common.context.Context;
import com.nexus.nexusrpg.domain.entity.planet.validator.PlanetValidator;
import org.springframework.stereotype.Component;

@Component
public class GetPlanet extends GetEntity<
        Planet,
        UPlanet,
        UPlanetDTO,
        UPlanetRDTO
        > {

    private final PlanetValidator validator;

    public GetPlanet(
            Context context,
            UPlanetRepository repository,
            UPlanetMapper mapper,
            UPlanetReferenceMapper refMapper,
            PlanetValidator validator,
            TaskMapper<UPlanetRDTO> taskMapper
    ) {

        super(
                context,
                repository,
                mapper,
                refMapper,
                taskMapper
        );

        this.validator = validator;
    }

    @Override
    protected void validate(UPlanet uPlanet) {
        validator.isAccessible(uPlanet);
    }
}