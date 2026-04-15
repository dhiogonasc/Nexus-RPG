package com.nexus.nexusrpg.common.service;

import com.nexus.nexusrpg.common.interfaces.Initializable;
import com.nexus.nexusrpg.domain.level.model.Level;
import com.nexus.nexusrpg.domain.level.service.LevelService;
import com.nexus.nexusrpg.domain.user.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InitApplicationService {

    private final LevelService levelService;
    private final List<Initializable<?>> initializers;

    public void initUser(User user) {
        initializers.forEach(initializer -> initializer.initialize(user));
    }

    public Level initialLevel() {
        return levelService.initialLevel();
    }
}
