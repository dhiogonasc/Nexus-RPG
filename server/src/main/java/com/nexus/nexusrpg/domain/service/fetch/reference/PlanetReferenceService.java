package com.nexus.nexusrpg.domain.service.fetch.reference;

import com.nexus.nexusrpg.common.context.Context;
import com.nexus.nexusrpg.common.service.ReferenceService;
import com.nexus.nexusrpg.domain.mapper.task.PlanetTaskMapper;
import com.nexus.nexusrpg.domain.model.relation.UPlanet;
import com.nexus.nexusrpg.domain.repository.relation.UserPlanetRepository;
import org.springframework.stereotype.Component;

@Component
public class PlanetReferenceService extends ReferenceService<UPlanet> {

    public PlanetReferenceService(
            Context context,
            UserPlanetRepository repository,
            PlanetTaskMapper taskMapper
    ) {

        super(context, repository, taskMapper);
    }
}