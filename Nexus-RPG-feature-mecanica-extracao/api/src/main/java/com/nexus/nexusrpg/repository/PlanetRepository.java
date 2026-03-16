package com.nexus.nexusrpg.repository;

import com.nexus.nexusrpg.model.entity.Planet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PlanetRepository extends JpaRepository<Planet, Long> {
	Optional<Planet> findByName(String name);
}
