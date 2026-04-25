package com.nexus.nexusrpg.common.task;

import java.util.List;

public record TaskDTO(
        List<EntityReferenceDTO> tasks,
        ProgressDTO progress
) {}