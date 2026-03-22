package com.nexus.nexusrpg.repository;

import com.nexus.nexusrpg.exception.BusinessException;
import com.nexus.nexusrpg.model.entity.User;
import com.nexus.nexusrpg.model.relation.UserMission;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;

import java.util.Optional;

public interface UserMissionRepository extends JpaRepository<UserMission, Long> {

    Optional<UserMission> findByUserIdAndMissionId(Long userId, Long missionId);

    default UserMission findByUserIdAndMissionIdOrThrow(Long userId, Long missionId){
        return findByUserIdAndMissionId(userId, missionId)
                .orElseThrow(() -> new BusinessException("User - Mission", "Nenhum registro encontrado", HttpStatus.BAD_REQUEST));
    }

    @Query("SELECT um FROM UserMission um " +
            "WHERE um.user.email = :email " +
            "AND (:planetId IS NULL OR um.mission.planet.id = :planetId)")
    Page<UserMission> findByEmailAndPlanet(
            @Param("email") String email,
            @Param("planetId") Long planetId,
            Pageable pageable
    );
}
