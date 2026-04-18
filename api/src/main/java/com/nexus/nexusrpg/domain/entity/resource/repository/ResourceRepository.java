package com.nexus.nexusrpg.domain.entity.resource.repository;

import com.nexus.nexusrpg.domain.model.Resource;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResourceRepository extends JpaRepository<Resource, Long> {
}
