package com.nexus.nexusrpg.domain.mapper.current;

import com.nexus.nexusrpg.common.mapper.Mapper;
import com.nexus.nexusrpg.domain.controller.dto.level.LevelDetail;
import com.nexus.nexusrpg.domain.controller.dto.level.LevelReference;
import com.nexus.nexusrpg.domain.model.Level;
import com.nexus.nexusrpg.domain.service.LevelService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CurrentLevelMapper implements Mapper<Level, LevelDetail> {

    private final LevelService levelService;

    @Override
    public LevelDetail map(Level level) {
        return new LevelDetail(
                level.getId(),
                level.getName().name(),
                level.getDescription(),
                mapNext(level)
        );
    }

    private LevelReference mapNext(Level level) {
        var next = levelService.findNextLevel(level);
        if (next == null) {return null;}

        return new LevelReference(
                next.getId(),
                next.getName().name(),
                next.getXpBonus(),
                next.getXpRequired()
        );
    }
}
