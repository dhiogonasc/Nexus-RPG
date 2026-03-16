package com.nexus.nexusrpg.service.extraction;

import com.nexus.nexusrpg.model.entity.Alternative;
import com.nexus.nexusrpg.model.entity.Level;
import com.nexus.nexusrpg.model.entity.UserStat;
import com.nexus.nexusrpg.repository.LevelRepository;
import org.springframework.stereotype.Service;

@Service
public class ProgressionService {

    private final LevelRepository levelRepository;

    public ProgressionService(LevelRepository levelRepository) {
        this.levelRepository = levelRepository;
    }

    public int applyVictory(UserStat userStat, Alternative alternative) {
        
        int xpEarned = calcularXpDaMissao(alternative);

        userStat.setXpCurrent(userStat.getXpCurrent() + xpEarned);
        userStat.setStreakCurrent(userStat.getStreakCurrent() + 1);

        checkLevelUp(userStat);

        return xpEarned;
    }


    public void applyDefeat(UserStat userStat) {
        // Zera a ofensiva atual
        userStat.setStreakCurrent(0);
    }


    private int calcularXpDaMissao(Alternative alternative) {
        try {
            return alternative.getQuestion().getMission().getXpReward();
        } catch (NullPointerException e) {
            
            return 50; 
        }
    }

    private void checkLevelUp(UserStat userStat) {
        Level currentLevel = userStat.getLevel();
        Long nextLevelId = currentLevel.getId() + 1;
        
        levelRepository.findById(nextLevelId).ifPresent(nextLevel -> {
            
            if (userStat.getXpCurrent() >= nextLevel.getXpRequired()) {
                userStat.setLevel(nextLevel);
                checkLevelUp(userStat); 
            }

        });
    }
}