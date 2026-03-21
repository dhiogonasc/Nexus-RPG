package com.nexus.nexusrpg.domain.resource.repository;

import com.nexus.nexusrpg.domain.resource.model.Resource;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResourceRepository extends JpaRepository<Resource, Long> {
}
