package com.nexus.nexusrpg.common.dto;

import java.util.List;

public record TaskDTO<T>(
        List<T> tasks,
        ProgressDTO progress
) {}