package com.nexus.nexusrpg.repository;

import com.nexus.nexusrpg.exception.BusinessException;
import com.nexus.nexusrpg.model.relation.UserMission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;

import java.util.Optional;

public interface UserMissionRepository extends JpaRepository<UserMission, Long> {

    Optional<UserMission> findByUserIdAndMissionId(Long userId, Long missionId);

    default UserMission findByUserIdAndMissionIdOrThrow(Long userId, Long missionId){
        return findByUserIdAndMissionId(userId, missionId)
                .orElseThrow(() -> new BusinessException("User - Mission", "Nenhum registro encontrado", HttpStatus.BAD_REQUEST));
    }
}
