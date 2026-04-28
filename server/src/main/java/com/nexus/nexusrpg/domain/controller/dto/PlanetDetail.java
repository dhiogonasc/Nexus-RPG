package com.nexus.nexusrpg.domain.controller.dto;

import com.nexus.nexusrpg.common.dto.EntityDetail;
import com.nexus.nexusrpg.common.task.TaskDTO;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class PlanetDetail extends EntityDetail {
    private final String content;
    private final long xpBonus;
    private final TaskDTO missions;
}