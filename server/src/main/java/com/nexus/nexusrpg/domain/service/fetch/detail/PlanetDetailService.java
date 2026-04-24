package com.nexus.nexusrpg.domain.service.fetch.detail;

import com.nexus.nexusrpg.common.context.Context;
import com.nexus.nexusrpg.domain.controller.dto.PlanetDTO;
import com.nexus.nexusrpg.domain.mapper.UPlanetMapper;
import com.nexus.nexusrpg.domain.model.relation.UPlanet;
import com.nexus.nexusrpg.domain.repository.relation.UserPlanetRepository;
import com.nexus.nexusrpg.domain.validator.PlanetValidator;
import org.springframework.stereotype.Service;

@Service
public class PlanetDetailService extends DetailService<UPlanet, PlanetDTO> {

    private final PlanetValidator validator;

    public PlanetDetailService(
            Context context,
            UserPlanetRepository repository,
            UPlanetMapper mapper,
            PlanetValidator validator
    ) {
        super(context, repository, mapper);
        this.validator = validator;
    }

    @Override
    protected void validate(UPlanet uPlanet) {
        this.validator.isAccessible(uPlanet);
    }
}
