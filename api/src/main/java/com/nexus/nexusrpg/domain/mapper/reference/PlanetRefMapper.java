package com.nexus.nexusrpg.domain.mapper.reference;

import com.nexus.nexusrpg.common.entity.RefMapper;
import com.nexus.nexusrpg.domain.controller.dto.planet.PlanetRefDTO;
import com.nexus.nexusrpg.domain.controller.dto.planet.UPExecutionRefDTO;
import com.nexus.nexusrpg.domain.entity.planet.repository.UserPlanetRepository;
import com.nexus.nexusrpg.domain.model.Planet;
import com.nexus.nexusrpg.domain.model.relation.UPlanet;
import com.nexus.nexusrpg.user.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PlanetRefMapper extends RefMapper<Planet, UPlanet, PlanetRefDTO> {

    private final UserPlanetRepository repository;

    @Override
    public PlanetRefDTO toRefDTO(UPlanet up){
        var planet = up.getPlanet();
        var planetExecution = new UPExecutionRefDTO(up.getStatus());

        return new PlanetRefDTO(
                planet.getId(),
                planet.getName(),
                planetExecution
        );
    }

    @Override
    protected UPlanet findRelation(User user, Planet planet) {
        return repository.findByUserIdAndPlanetIdOrThrow(user.getId(), planet.getId());
    }
}
