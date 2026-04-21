package com.nexus.nexusrpg.common.dto;

import java.util.List;

public record MainDTO<T>(
        List<T> tasks,
        ProgressDTO progress
) {}