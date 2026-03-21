package com.nexus.nexusrpg.domain.level.repository;

import com.nexus.nexusrpg.domain.level.model.Level;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LevelRepository extends JpaRepository<Level, Long> {
}
