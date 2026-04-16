package com.nexus.nexusrpg.domain.entity.level.repository;

import com.nexus.nexusrpg.domain.entity.level.model.Level;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LevelRepository extends JpaRepository<Level, Long> {
    Optional<Level> findByOrder(int i);
}
