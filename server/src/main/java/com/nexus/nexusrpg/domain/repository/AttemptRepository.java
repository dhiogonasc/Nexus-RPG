package com.nexus.nexusrpg.domain.repository;

import com.nexus.nexusrpg.core.exception.BusinessException;
import com.nexus.nexusrpg.domain.model.relation.Attempt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import static org.springframework.http.HttpStatus.NOT_FOUND;

public interface AttemptRepository extends JpaRepository<Attempt, Long> {

    @Query("SELECT COUNT(a) > 0 " +
            "FROM Attempt a" +
            " WHERE a.uMission.id = :uMissionId " +
            "AND a.endAt IS NULL")
    boolean existsByUMissionIdAndEndAtIsNull(Long uMissionId);

    default Attempt findByIdOrThrow(Long id){
     return findById(id)
             .orElseThrow(() -> new BusinessException("Attempt", "Nenhum registro encontrado", NOT_FOUND));
    }
}
