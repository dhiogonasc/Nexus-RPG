package com.nexus.nexusrpg.domain.mapper.reference;

import com.nexus.nexusrpg.common.mapping.ExecutionMapper;
import com.nexus.nexusrpg.common.task.EntityReferenceDTO;
import com.nexus.nexusrpg.domain.repository.relation.UserPlanetRepository;
import com.nexus.nexusrpg.domain.model.Planet;
import com.nexus.nexusrpg.domain.model.relation.UPlanet;
import com.nexus.nexusrpg.user.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UPlanetReferenceMapper extends ReferenceMapper<Planet, UPlanet> {

    private final ExecutionMapper<UPlanet> executionMapper;
    private final UserPlanetRepository uPlanetRepository;

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
