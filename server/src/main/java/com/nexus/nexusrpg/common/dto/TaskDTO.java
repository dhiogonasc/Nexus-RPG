package com.nexus.nexusrpg.common.dto;

import java.util.List;

public record TaskDTO<T extends Task>(
        List<T> tasks,
        ProgressDTO progress
) {}