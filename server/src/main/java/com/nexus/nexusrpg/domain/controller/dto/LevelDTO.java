package com.nexus.nexusrpg.domain.controller.dto;

import com.nexus.nexusrpg.common.dto.StaticReference;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@RequiredArgsConstructor
public class LevelDTO implements StaticReference {

    private final Long id;
    private final String name;
    private final String description;
    private final long xpRequired;
    private final long xpNextLevel;
    private final long xpBonus;

    @Override
    public Long id() {
        return this.id;
    }

    @Override
    public String name() {
        return this.name;
    }

    @Override
    public String description() {
        return this.description;
    }
}
