package com.nexus.nexusrpg.domain.repository;

import com.nexus.nexusrpg.domain.model.Mission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MissionRepository extends JpaRepository<Mission, Long> {
}
