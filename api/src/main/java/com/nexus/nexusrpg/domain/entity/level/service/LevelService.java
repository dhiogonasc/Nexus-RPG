package com.nexus.nexusrpg.domain.entity.level.service;

import com.nexus.nexusrpg.core.exception.BusinessException;
import com.nexus.nexusrpg.domain.model.Level;
import com.nexus.nexusrpg.domain.entity.level.repository.LevelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
@RequiredArgsConstructor
public class LevelService {

    private final LevelRepository levelRepository;

    public Level initialLevel(){
        return levelRepository.findById(1L)
                .orElseThrow(() -> new BusinessException(
                        "Level",
                        "Level 1 não encontrado",
                        NOT_FOUND
                ));
    }

    public Optional<Level> findNextLevel(Level currentLevel) {
        return levelRepository.findByOrder(currentLevel.getOrder() + 1);
    }
}
