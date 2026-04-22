package com.nexus.nexusrpg.domain.mapper.reference;

import com.nexus.nexusrpg.common.mapping.mapper.ExecutionMapper;
import com.nexus.nexusrpg.common.mapping.mapper.ReferenceMapper;
import com.nexus.nexusrpg.common.mapping.mapper.TaskMapper;
import com.nexus.nexusrpg.common.dto.EntityReferenceDTO;
import com.nexus.nexusrpg.domain.repository.relation.UPlanetRepository;
import com.nexus.nexusrpg.domain.model.Planet;
import com.nexus.nexusrpg.domain.model.relation.UPlanet;
import com.nexus.nexusrpg.user.model.User;
import org.springframework.stereotype.Component;

@Component
public class UPlanetReferenceMapper extends ReferenceMapper<Planet, UPlanet> {

    private final ExecutionMapper<UPlanet> executionMapper;
    private final UPlanetRepository uPlanetRepository;

    public UPlanetReferenceMapper(
            TaskMapper taskMapper,
            ExecutionMapper<UPlanet> executionMapper,
            UPlanetRepository uPlanetRepository
    ) {
        super(taskMapper);
        this.executionMapper = executionMapper;
        this.uPlanetRepository = uPlanetRepository;
    }

    @Override
    public EntityReferenceDTO toReferenceDTO(UPlanet uPlanet){

        var planet = uPlanet.getPlanet();

        return new EntityReferenceDTO(
                planet.getId(),
                planet.getName().toString(),
                executionMapper.map(uPlanet)
        );
    }

    @Override
    protected UPlanet findRelation(User user, Planet planet) {
        return uPlanetRepository.findByUserIdAndEntityId(user.getId(), planet.getId());
    }
}
