package com.nexus.nexusrpg.common.task;

import com.nexus.nexusrpg.common.dto.EntityDynamicReference;

import java.util.List;

public record TaskDTO(
        List<EntityDynamicReference> tasks,
        ProgressDTO progress
) {}