package com.nexus.nexusrpg.domain.planet.service;

import com.nexus.nexusrpg.common.service.InitEntity;
import com.nexus.nexusrpg.domain.planet.model.Planet;
import com.nexus.nexusrpg.domain.planet.repository.PlanetRepository;
import com.nexus.nexusrpg.domain.user.model.User;
import com.nexus.nexusrpg.domain.user.model.relation.UserPlanet;
import com.nexus.nexusrpg.domain.user.repository.relation.UserPlanetRepository;
import org.springframework.stereotype.Service;

@Service
public class InitPlanet extends InitEntity<Planet, UserPlanet> {

    public InitPlanet(
            PlanetRepository planetRepository,
            UserPlanetRepository userPlanetRepository
    ){

        super(planetRepository, userPlanetRepository);
    }

    @Override
    protected UserPlanet mapToRelation(User user, Planet planet) {

        return UserPlanet.initialize(user, planet);
    }
}
