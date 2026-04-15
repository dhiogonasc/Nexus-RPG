package com.nexus.nexusrpg.domain.planet.repository;

import com.nexus.nexusrpg.domain.planet.model.Planet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface PlanetRepository extends JpaRepository<Planet, Long> {
}
