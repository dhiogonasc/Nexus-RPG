package com.nexus.nexusrpg.domain.level.repository;

import com.nexus.nexusrpg.domain.level.model.Level;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LevelRepository extends JpaRepository<Level, Long> {
    List<Level> findAllByXpRequiredAsc();
}
