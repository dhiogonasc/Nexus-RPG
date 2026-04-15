package com.nexus.nexusrpg.domain.entity.planet.repository;

import com.nexus.nexusrpg.domain.entity.planet.model.Planet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanetRepository extends JpaRepository<Planet, Long> {
}
