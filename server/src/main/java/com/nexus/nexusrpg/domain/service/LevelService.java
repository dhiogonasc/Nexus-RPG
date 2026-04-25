package com.nexus.nexusrpg.domain.service;

import com.nexus.nexusrpg.domain.model.Level;
import com.nexus.nexusrpg.domain.repository.LevelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LevelService {

    private final LevelRepository levelRepository;

    public Level findInitialLevel(){
        return levelRepository
                .findByIdOrThrow(1L);
    }

    public Level findNextLevel(Level currentLevel) {
        return levelRepository
                .findByOrderOrThrow(currentLevel.getOrder() + 1);
    }
}
