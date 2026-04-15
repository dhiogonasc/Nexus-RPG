package com.nexus.nexusrpg.domain.user.repository.relation;

import com.nexus.nexusrpg.core.exception.BusinessException;
import com.nexus.nexusrpg.domain.user.model.relation.UserMissionAttempt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;

import java.util.Optional;

public interface AttemptRepository extends JpaRepository<UserMissionAttempt, Long> {

    default UserMissionAttempt findByIdOrThrow(Long id) {
        return findById(id)
                .orElseThrow(() -> new BusinessException("Attempt", "Nenhum registro encontrado!", HttpStatus.BAD_REQUEST));
    }

    boolean existsByUserMissionIdAndEndAtIsNull(Long id);
}
