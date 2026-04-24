package com.nexus.nexusrpg.domain.repository;

import com.nexus.nexusrpg.core.exception.BusinessException;
import com.nexus.nexusrpg.domain.model.relation.Attempt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.NOT_FOUND;

public interface AttemptRepository extends JpaRepository<Attempt, Long> {

    boolean existsByMissionIdAndEndAtIsNull(Long uMissionId);

    default Attempt findByIdOrThrow(Long id){
     return findById(id)
             .orElseThrow(() -> new BusinessException("Attempt", "Nenhum registro encontrado", NOT_FOUND));
    }
}
