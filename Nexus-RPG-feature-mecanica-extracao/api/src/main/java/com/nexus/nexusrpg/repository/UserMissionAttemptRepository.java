package com.nexus.nexusrpg.repository;

import com.nexus.nexusrpg.model.entity.UserMissionAttempt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMissionAttemptRepository extends JpaRepository<UserMissionAttempt, Long> {
}