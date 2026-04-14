package com.nexus.nexusrpg.domain.planet.service;

import com.nexus.nexusrpg.common.interfaces.Initializable;
import com.nexus.nexusrpg.domain.planet.repository.PlanetRepository;
import com.nexus.nexusrpg.domain.user.model.User;
import com.nexus.nexusrpg.domain.user.model.relation.UserPlanet;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InitPlanetService implements Initializable<UserPlanet> {

    private final PlanetRepository planetRepository;

    @Override
    public List<UserPlanet> initialize(User user) {

        var allPlanets = planetRepository.findAll();

        return allPlanets.stream()
                .map(planet -> UserPlanet.initialize(user, planet))
                .toList();
    }
}
