package com.nexus.nexusrpg.repository;

import com.nexus.nexusrpg.model.entity.Resource;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResourceRepository extends JpaRepository<Resource, Long> {
}
