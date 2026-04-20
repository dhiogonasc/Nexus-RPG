package com.nexus.nexusrpg.domain.entity.mission.repository;

import com.nexus.nexusrpg.core.exception.BusinessException;
import com.nexus.nexusrpg.domain.entity.mission.model.UAttempt;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;

import java.util.Optional;

public interface UAttemptRepository extends JpaRepository<UAttempt, Long> {

    @EntityGraph(attributePaths = {"uMission.mission.questions"})
    @Query("SELECT ua FROM UAttempt ua WHERE ua.id = :id")
    Optional<UAttempt> findByIdWithDetails(@Param("id") Long id);

    default UAttempt findByIdOrThrow(Long id) {
        return findByIdWithDetails(id)
                .orElseThrow(() -> new BusinessException(
                        "Attempt",
                        "Nenhum registro encontrado!",
                        HttpStatus.BAD_REQUEST)
                );
    }

    @Query("SELECT COUNT(ua) > 0 " +
            "FROM UAttempt ua " +
            "WHERE ua.uMission.id = :uMissionId " +
            "AND ua.endAt IS NULL")
    boolean existsActiveAttempt(@Param("uMissionId") Long id);
}
