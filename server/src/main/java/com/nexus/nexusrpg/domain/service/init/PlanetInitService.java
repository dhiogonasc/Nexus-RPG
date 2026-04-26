package com.nexus.nexusrpg.domain.service.init;

import com.nexus.nexusrpg.common.service.EntityInitService;
import com.nexus.nexusrpg.domain.model.Planet;
import com.nexus.nexusrpg.domain.model.relation.UPlanet;
import com.nexus.nexusrpg.domain.repository.PlanetRepository;
import com.nexus.nexusrpg.domain.repository.relation.UserPlanetRepository;
import com.nexus.nexusrpg.user.model.User;
import org.springframework.stereotype.Service;

@Service
public class PlanetInitService extends EntityInitService<Planet, UPlanet> {

    public PlanetInitService(
            PlanetRepository planetRepository,
            UserPlanetRepository uPlanetRepository
    ){
        super(planetRepository, uPlanetRepository);
    }

    @Override
    protected UPlanet initRelation(User user, Planet planet) {
        return UPlanet.initialize(user, planet);
    }
}
