package com.nexus.nexusrpg.domain.mission.repository;

import com.nexus.nexusrpg.domain.mission.model.Mission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MissionRepository extends JpaRepository<Mission, Long> {
}
