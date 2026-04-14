package com.nexus.nexusrpg.domain.level.service;

import com.nexus.nexusrpg.core.exception.BusinessException;
import com.nexus.nexusrpg.domain.level.model.Level;
import com.nexus.nexusrpg.domain.level.repository.LevelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LevelService {

    private final LevelRepository levelRepository;

    public Level initialLevel(){

        return  levelRepository.findById(1L)
                .orElseThrow(() -> new BusinessException("Level", "Level 1 não encontrado", HttpStatus.BAD_REQUEST));
    }
}
