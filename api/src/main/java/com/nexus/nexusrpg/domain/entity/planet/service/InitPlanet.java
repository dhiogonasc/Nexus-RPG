package com.nexus.nexusrpg.domain.entity.planet.service;

import com.nexus.nexusrpg.common.entity.InitEntity;
import com.nexus.nexusrpg.domain.model.Planet;
import com.nexus.nexusrpg.domain.repository.PlanetRepository;
import com.nexus.nexusrpg.user.model.User;
import com.nexus.nexusrpg.domain.model.relation.UPlanet;
import com.nexus.nexusrpg.domain.repository.UPlanetRepository;
import org.springframework.stereotype.Service;

@Service
public class InitPlanet extends InitEntity<Planet, UPlanet> {

    public InitPlanet(
            PlanetRepository planetRepository,
            UPlanetRepository uPlanetRepository
    ){

        super(planetRepository, uPlanetRepository);
    }

    @Override
    protected UPlanet initRelation(User user, Planet planet) {

        return UPlanet.initialize(user, planet);
    }
}
