package com.nexus.nexusrpg.domain.repository;

import com.nexus.nexusrpg.domain.model.Planet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanetRepository extends JpaRepository<Planet, Long> {
}
