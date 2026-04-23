package com.nexus.nexusrpg.common.task;

import java.util.List;

public record TaskDTO<T extends Task>(
        List<T> tasks,
        ProgressDTO progress
) {}