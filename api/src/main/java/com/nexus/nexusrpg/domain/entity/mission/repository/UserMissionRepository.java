package com.nexus.nexusrpg.domain.entity.mission.repository;

import com.nexus.nexusrpg.common.entity.RelationRepository;
import com.nexus.nexusrpg.core.exception.BusinessException;
import com.nexus.nexusrpg.domain.user.model.relation.UserMission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.NOT_FOUND;

public interface UserMissionRepository extends JpaRepository<UserMission, Long>, RelationRepository<UserMission> {

    List<UserMission> findByUserId(Long userId);

    @Override
    @Query("SELECT um FROM UserMission um WHERE um.user.id = :userId AND um.mission.id = :baseId")
    Optional<UserMission> findByUserIdAndBaseId(@Param("userId") Long userId, @Param("baseId") Long baseId);

    default UserMission findByUserIdAndMissionIdOrThrow(Long userId, Long missionId) {
        return findByUserIdAndBaseId(userId, missionId)
                .orElseThrow(() -> new BusinessException("Mission", "Nenhum registro encontrado", NOT_FOUND));
    }
}
