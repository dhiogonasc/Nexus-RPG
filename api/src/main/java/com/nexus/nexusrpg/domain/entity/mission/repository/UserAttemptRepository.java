package com.nexus.nexusrpg.domain.entity.mission.repository;

import com.nexus.nexusrpg.core.exception.BusinessException;
import com.nexus.nexusrpg.domain.entity.mission.model.UserAttempt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;

public interface UserAttemptRepository extends JpaRepository<UserAttempt, Long> {

    default UserAttempt findByIdOrThrow(Long id) {
        return findById(id)
                .orElseThrow(() -> new BusinessException("Attempt", "Nenhum registro encontrado!", HttpStatus.BAD_REQUEST));
    }

    boolean existsByUserMissionIdAndEndAtIsNull(Long id);
}
