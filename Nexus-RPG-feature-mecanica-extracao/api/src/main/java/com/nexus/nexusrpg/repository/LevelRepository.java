package com.nexus.nexusrpg.repository;

import com.nexus.nexusrpg.model.entity.Level;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LevelRepository extends JpaRepository<Level, Long> {
    Optional<Level> findByNumber(int i);

    default Level findByNumberOrThrow(int i){
        return findByNumber(i)
                .orElseThrow(() -> new EntityNotFoundException("Nenhum level encontrado para: " + i));
    };

}
