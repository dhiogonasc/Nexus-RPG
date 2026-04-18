package com.nexus.nexusrpg.domain.mapper.reference;

import com.nexus.nexusrpg.common.entity.RefMapper;
import com.nexus.nexusrpg.domain.controller.dto.planet.UPlanetDTOR;
import com.nexus.nexusrpg.domain.controller.dto.planet.UPlanetExecDTOR;
import com.nexus.nexusrpg.domain.entity.planet.repository.UserPlanetRepository;
import com.nexus.nexusrpg.domain.model.Planet;
import com.nexus.nexusrpg.domain.model.relation.UPlanet;
import com.nexus.nexusrpg.user.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UPlanetRefMapper extends RefMapper<Planet, UPlanet, UPlanetDTOR> {

    private final UserPlanetRepository repository;

    @Override
    public UPlanetDTOR toRefDTO(UPlanet uPlanet){

        var planet = uPlanet.getPlanet();
        var uPlanetExecution = new UPlanetExecDTOR(uPlanet.getStatus());

        return new UPlanetDTOR(
                planet.getId(),
                planet.getName(),
                uPlanetExecution
        );
    }

    @Override
    protected UPlanet findRelation(User user, Planet planet) {
        return repository.findByUserIdAndPlanetIdOrThrow(user.getId(), planet.getId());
    }
}
