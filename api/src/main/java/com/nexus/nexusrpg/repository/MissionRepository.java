package com.nexus.nexusrpg.repository;

import com.nexus.nexusrpg.model.entity.Mission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MissionRepository extends JpaRepository<Mission, Long> {
}
