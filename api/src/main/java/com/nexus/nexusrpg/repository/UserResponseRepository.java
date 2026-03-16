package com.nexus.nexusrpg.repository;

import com.nexus.nexusrpg.model.relation.UserResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserResponseRepository extends JpaRepository<UserResponse, Long> {
}