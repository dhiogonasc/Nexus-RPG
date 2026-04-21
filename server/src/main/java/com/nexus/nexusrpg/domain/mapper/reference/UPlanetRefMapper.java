package com.nexus.nexusrpg.domain.mapper.reference;

import com.nexus.nexusrpg.common.mapper.RefMapper;
import com.nexus.nexusrpg.common.state.mapper.ExecutionMapper;
import com.nexus.nexusrpg.domain.controller.dto.planet.UPlanetDTOR;
import com.nexus.nexusrpg.domain.repository.relation.UPlanetRepository;
import com.nexus.nexusrpg.domain.model.Planet;
import com.nexus.nexusrpg.domain.model.relation.UPlanet;
import com.nexus.nexusrpg.user.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UPlanetRefMapper
        extends RefMapper<Planet, UPlanet, UPlanetDTOR>
        implements ExecutionMapper<UPlanet>
{

    private final UPlanetRepository uPlanetRepository;

    @Override
    public UPlanetDTOR toRefDTO(UPlanet uPlanet){

        var planet = uPlanet.getPlanet();

        return new UPlanetDTOR(
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
