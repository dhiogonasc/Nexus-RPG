package com.nexus.nexusrpg.domain.entity.mission.repository;

import com.nexus.nexusrpg.domain.entity.mission.model.Mission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MissionRepository extends JpaRepository<Mission, Long> {
}
