package com.nexus.nexusrpg.domain.user.repository.relation;

import com.nexus.nexusrpg.domain.user.model.relation.UserResponse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserResponseRepository extends JpaRepository<UserResponse, Long> {
}
