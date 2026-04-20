package com.nexus.nexusrpg.domain.entity.mission.repository;

import com.nexus.nexusrpg.domain.entity.mission.model.UserResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserResponseRepository extends JpaRepository<UserResponse, Long> {

    @Query("SELECT ur FROM UserResponse ur JOIN FETCH ur.alternative WHERE ur.attempt.id = :attemptId")
    List<UserResponse> findByAttemptId(@Param("attemptId") Long attemptId);

    Optional<UserResponse> findByAttemptIdAndQuestionId(Long attemptId, Long questionId);

    long countByAttemptId(Long id);
}
