package com.nexus.nexusrpg.domain.repository.relation;

import com.nexus.nexusrpg.common.entity.repository.UEntityRepository;
import com.nexus.nexusrpg.core.exception.BusinessException;
import com.nexus.nexusrpg.domain.model.relation.UMission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.NOT_FOUND;

public interface UMissionRepository extends JpaRepository<UMission, Long>, UEntityRepository<UMission> {

    @Override
    List<UMission> findByUserId(Long userId);

    @Override
    default UMission findByUserIdAndEntityId(Long userId, Long entityId){
        return findUEntity(userId, entityId)
                .orElseThrow(() -> new BusinessException(
                        "Mission",
                        "Nenhum registro encontrado",
                        NOT_FOUND)
                );
    }

    @Query("SELECT um " +
            "FROM UMission um " +
            "JOIN FETCH um.mission " +
            "WHERE um.user.id = :userId " +
            "AND um.mission.id = :entityId")
    Optional<UMission> findUEntity(@Param("userId") Long userId, @Param("entityId") Long entityId);

    @Override
    @Query("SELECT COUNT(um) " +
            "FROM UMission um " +
            "WHERE um.user.id = :userId ")
    long countTotalTasks(@Param("userId") Long userId);

    @Override
    @Query("SELECT COUNT(um) " +
            "FROM UMission um " +
            "WHERE um.user.id = :userId " +
            "AND um.execution.status = 'COMPLETED'")
    long countCompletedTasks(@Param("userId") Long userId);

    Optional<UMission> findByUserIdAndMissionPlanetIdAndMissionOrder(Long userId, Long planetId, int nextMissionOrder);

}
