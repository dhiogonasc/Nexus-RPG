package com.nexus.nexusrpg.domain.service.get;

import com.nexus.nexusrpg.common.mapping.ProgressMapper;
import com.nexus.nexusrpg.domain.controller.dto.PlanetDTO;
import com.nexus.nexusrpg.domain.mapper.UPlanetMapper;
import com.nexus.nexusrpg.domain.mapper.reference.UPlanetReferenceMapper;
import com.nexus.nexusrpg.domain.model.Planet;
import com.nexus.nexusrpg.domain.model.relation.UPlanet;
import com.nexus.nexusrpg.domain.repository.relation.UserPlanetRepository;
import com.nexus.nexusrpg.common.context.Context;
import com.nexus.nexusrpg.domain.validator.PlanetValidator;
import org.springframework.stereotype.Component;

@Component
public class PlanetGetService extends GetService<
        Planet,
        UPlanet,
        PlanetDTO
        > {

    private final PlanetValidator validator;

    public PlanetGetService(
            Context context,
            UserPlanetRepository repository,
            UPlanetMapper mapper,
            UPlanetReferenceMapper refMapper,
            PlanetValidator validator,
            ProgressMapper progressMapper
    ) {

        super(
                context,
                repository,
                mapper,
                refMapper,
                progressMapper
        );

        this.validator = validator;
    }

    @Override
    protected void validate(UPlanet uPlanet) {
        validator.isAccessible(uPlanet);
    }
}