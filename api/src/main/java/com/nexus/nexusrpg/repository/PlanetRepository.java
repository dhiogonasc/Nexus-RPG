package com.nexus.nexusrpg.repository;

import com.nexus.nexusrpg.model.entity.Planet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface PlanetRepository extends JpaRepository<Planet, Long> {

    @Query("SELECT p FROM Planet p LEFT JOIN FETCH p.missions WHERE p.id = :planetId")
    Optional<Planet> findIdlWithMissions(Long planetId);
}
