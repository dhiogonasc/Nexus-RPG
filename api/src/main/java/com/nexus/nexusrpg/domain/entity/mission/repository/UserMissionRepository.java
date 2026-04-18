package com.nexus.nexusrpg.domain.entity.mission.repository;

import com.nexus.nexusrpg.common.entity.UEntityRepository;
import com.nexus.nexusrpg.core.exception.BusinessException;
import com.nexus.nexusrpg.domain.model.relation.UMission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.NOT_FOUND;

public interface UserMissionRepository extends JpaRepository<UMission, Long>, UEntityRepository<UMission> {

    List<UMission> findByUserId(Long userId);

    @Override
    @Query("SELECT um FROM UserMission um WHERE um.user.id = :userId AND um.mission.id = :baseId")
    Optional<UMission> findByUserIdAndEntityId(@Param("userId") Long userId, @Param("baseId") Long baseId);

    default UMission findByUserIdAndMissionIdOrThrow(Long userId, Long missionId) {
        return findByUserIdAndEntityId(userId, missionId)
                .orElseThrow(() -> new BusinessException("Mission", "Nenhum registro encontrado", NOT_FOUND));
    }

    Optional<UMission> findByUserIdAndMissionPlanetIdAndMissionOrder(Long userId, Long missionId, int nextMissionOrder);
    Optional<List<UMission>> findByUserIdAndMissionPlanetId(Long userId, Long planetId);

    default List<UMission> findByUserIdAndMissionPlanetIdOrThrow(Long userId, Long planetId){

        return findByUserIdAndMissionPlanetId(userId, planetId)
                .orElseThrow(() -> new BusinessException("Mission", "Nenhum registro encontrado", NOT_FOUND));
    }

}
