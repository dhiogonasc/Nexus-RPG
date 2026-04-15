package com.nexus.nexusrpg.common.init;

import com.nexus.nexusrpg.domain.level.model.Level;
import com.nexus.nexusrpg.domain.level.service.LevelService;
import com.nexus.nexusrpg.domain.user.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InitApplication {

    private final LevelService levelService;
    private final List<Initializable> initializers;

    public void initUser(User user) {
        initializers.forEach(initializer -> initializer.initialize(user));
    }

    public Level initialLevel() {
        return levelService.initialLevel();
    }
}
