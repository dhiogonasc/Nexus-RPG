package com.nexus.nexusrpg.domain.repository.relation;

import com.nexus.nexusrpg.core.exception.BusinessException;
import com.nexus.nexusrpg.domain.model.relation.UMission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.NOT_FOUND;

public interface UserMissionRepository extends JpaRepository<UMission, Long>, UserEntityRepository<UMission> {

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

    @Query("SELECT um " +
            "FROM UMission um " +
            "JOIN FETCH um.mission " +
            "WHERE um.user.id = :userId " +
            "AND um.mission.planet.id = :planetId " +
            "AND um.mission.order = :missionOrder"
    )
    Optional<UMission> findByUserIdAndPlanetIdAndMissionOrder(
            @Param("userId") Long userId,
            @Param("planetId") Long planetId,
            @Param("missionOrder") int missionOrder
    );
}
