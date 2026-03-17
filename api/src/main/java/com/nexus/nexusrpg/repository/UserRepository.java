package com.nexus.nexusrpg.repository;

import com.nexus.nexusrpg.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByEmail(String email);
}
