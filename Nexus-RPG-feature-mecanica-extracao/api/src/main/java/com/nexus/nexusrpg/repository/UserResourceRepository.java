package com.nexus.nexusrpg.repository;

import com.nexus.nexusrpg.model.entity.UserResource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserResourceRepository extends JpaRepository<UserResource, Long> {

    Optional<UserResource> findByUserIdAndResourceId(Long userId, Long resourceId);
}