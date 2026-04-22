package com.nexus.nexusrpg.domain.mapper.reference;

import com.nexus.nexusrpg.common.mapper.ReferenceMapper;
import com.nexus.nexusrpg.common.state.mapper.ExecutionMapper;
import com.nexus.nexusrpg.domain.controller.dto.planet.UPlanetRDTO;
import com.nexus.nexusrpg.domain.repository.relation.UPlanetRepository;
import com.nexus.nexusrpg.domain.model.Planet;
import com.nexus.nexusrpg.domain.model.relation.UPlanet;
import com.nexus.nexusrpg.user.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UPlanetReferenceMapper
        extends ReferenceMapper<Planet, UPlanet, UPlanetRDTO>
        implements ExecutionMapper<UPlanet>
{

    private final UPlanetRepository uPlanetRepository;

    @Override
    public UPlanetRDTO toRefDTO(UPlanet uPlanet){

        var planet = uPlanet.getPlanet();

        return new UPlanetRDTO(
                planet.getId(),
                planet.getName(),
                mapExecution(uPlanet)
        );
    }

    @Override
    protected UPlanet findRelation(User user, Planet planet) {
        return uPlanetRepository.findByUserIdAndEntityId(user.getId(), planet.getId());
    }
}
