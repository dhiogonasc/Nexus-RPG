package com.nexus.nexusrpg.domain.entity.planet.service;

import com.nexus.nexusrpg.common.entity.InitEntity;
import com.nexus.nexusrpg.domain.model.Planet;
import com.nexus.nexusrpg.domain.entity.planet.repository.PlanetRepository;
import com.nexus.nexusrpg.user.model.User;
import com.nexus.nexusrpg.domain.model.relation.UserPlanet;
import com.nexus.nexusrpg.domain.entity.planet.repository.UserPlanetRepository;
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
