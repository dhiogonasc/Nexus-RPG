package com.nexus.nexusrpg.domain.user.service;

import com.nexus.nexusrpg.common.entity.Initializable;
import com.nexus.nexusrpg.domain.entity.level.model.Level;
import com.nexus.nexusrpg.domain.entity.level.service.LevelService;
import com.nexus.nexusrpg.domain.user.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InitUser {

    private final LevelService levelService;
    private final List<Initializable> initializers;

    public void initialize(User user) {
        initializers.forEach(initializer -> initializer.initialize(user));
    }

    public Level initialLevel() {
        return levelService.initialLevel();
    }
}
