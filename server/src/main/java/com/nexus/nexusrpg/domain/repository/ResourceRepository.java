package com.nexus.nexusrpg.domain.repository;

import com.nexus.nexusrpg.domain.model.Resource;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResourceRepository extends JpaRepository<Resource, Long> {
}
