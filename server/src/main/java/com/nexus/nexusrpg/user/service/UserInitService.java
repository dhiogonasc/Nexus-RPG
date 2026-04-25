package com.nexus.nexusrpg.user.service;

import com.nexus.nexusrpg.common.service.Initializable;
import com.nexus.nexusrpg.domain.model.Level;
import com.nexus.nexusrpg.domain.service.LevelService;
import com.nexus.nexusrpg.user.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserInitService {

    private final LevelService levelService;
    private final List<Initializable> initializers;

    public void initialize(User user) {
        initializers.forEach(initializer -> initializer.initialize(user));
    }

    public Level initialLevel() {
        return levelService.findInitialLevel();
    }
}
