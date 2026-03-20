package com.nexus.nexusrpg.repository;

import com.nexus.nexusrpg.exception.BusinessException;
import com.nexus.nexusrpg.model.entity.Planet;
import com.nexus.nexusrpg.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public interface PlanetRepository extends JpaRepository<Planet, Long> {

    @Query("SELECT p FROM Planet p LEFT JOIN FETCH p.missions WHERE p.id = :planetId")
    Optional<Planet> findIdlWithMissions(Long planetId);
}
