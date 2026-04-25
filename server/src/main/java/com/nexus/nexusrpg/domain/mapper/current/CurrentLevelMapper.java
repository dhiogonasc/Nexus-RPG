package com.nexus.nexusrpg.domain.mapper.current;

import com.nexus.nexusrpg.common.mapper.Mapper;
import com.nexus.nexusrpg.domain.controller.dto.LevelReference;
import com.nexus.nexusrpg.domain.model.Level;
import com.nexus.nexusrpg.domain.service.LevelService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CurrentLevelMapper implements Mapper<Level, LevelReference> {

    private final LevelService levelService;

    @Override
    public LevelReference map(Level level) {
        return LevelReference.builder()
                .id(level.getId())
                .name(level.getName().toString())
                .description(level.getDescription())
                .xpRequired(level.getXpRequired())
                .xpBonus(level.getXpBonus())
                .xpNextLevel(getXpNextLevel(level))
                .build();
    }

    private long getXpNextLevel(Level level) {
        return levelService.findNextLevel(level).getXpRequired();
    }
}
