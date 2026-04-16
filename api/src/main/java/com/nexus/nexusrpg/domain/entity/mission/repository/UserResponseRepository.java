package com.nexus.nexusrpg.domain.entity.mission.repository;

import com.nexus.nexusrpg.domain.entity.mission.model.UserResponse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserResponseRepository extends JpaRepository<UserResponse, Long> {

    List<UserResponse> findByAttemptId(Long attemptId);
}
