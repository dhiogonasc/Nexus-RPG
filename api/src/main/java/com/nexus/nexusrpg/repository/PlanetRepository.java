package com.nexus.nexusrpg.repository;

import com.nexus.nexusrpg.exception.BusinessException;
import com.nexus.nexusrpg.model.entity.Planet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;

import java.util.Arrays;
import java.util.List;

public interface PlanetRepository extends JpaRepository<Planet, Long> {

    default Planet findByIdOrElseThrow(Long id){
        return findById(id)
                .orElseThrow(() -> new BusinessException("Planet", "Planeta não encontrado", HttpStatus.BAD_REQUEST));
    }
}
