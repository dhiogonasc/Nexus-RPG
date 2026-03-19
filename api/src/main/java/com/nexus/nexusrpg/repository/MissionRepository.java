package com.nexus.nexusrpg.repository;

import com.nexus.nexusrpg.exception.BusinessException;
import com.nexus.nexusrpg.model.entity.Mission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;

public interface MissionRepository extends JpaRepository<Mission, Long> {

    default Mission findByIdOrElseThrow(Long id){
        return findById(id)
                .orElseThrow(() -> new BusinessException("Mission", "Missão não encontrada", HttpStatus.BAD_REQUEST));
    }
}
