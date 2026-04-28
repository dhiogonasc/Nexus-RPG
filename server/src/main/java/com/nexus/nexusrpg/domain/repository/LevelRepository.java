package com.nexus.nexusrpg.domain.repository;

import com.nexus.nexusrpg.domain.model.Level;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LevelRepository extends JpaRepository<Level, Long> {
    Optional<Level> findByOrder(int i);
}
