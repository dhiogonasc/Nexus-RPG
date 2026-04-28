package com.nexus.nexusrpg.domain.service;

import com.nexus.nexusrpg.domain.model.Level;
import com.nexus.nexusrpg.domain.repository.LevelRepository;
import com.nexus.nexusrpg.user.model.User;
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
                .findByOrder(currentLevel.getNextOrder())
                .orElse(null);
    }

    public void levelUp(User user){
        while (!user.getLevel().isLast()) {
            Level nextLevel = findNextLevel(user.getLevel());
            if (user.getXp() >= nextLevel.getXpRequired()) {
                user.up(nextLevel);
            } else {
                break;
            }
        }
    }
}
