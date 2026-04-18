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
            "JOIN FETCH um.planet " +
            "WHERE ur.user.id = :userId " +
            "AND ur.planet.id = :entityId")
    Optional<UMission> findUEntity(@Param("userId") Long userId, @Param("entityId") Long entityId);

    Optional<UMission> findByUserIdAndMissionPlanetIdAndMissionOrder(Long userId, Long missionId, int nextMissionOrder);
    Optional<List<UMission>> findByUserIdAndMissionPlanetId(Long userId, Long planetId);
    default List<UMission> findByUserIdAndMissionPlanetIdOrThrow(Long userId, Long planetId){
        return findByUserIdAndMissionPlanetId(userId, planetId)
                .orElseThrow(() -> new BusinessException("Mission", "Nenhum registro encontrado", NOT_FOUND));
    }

}
