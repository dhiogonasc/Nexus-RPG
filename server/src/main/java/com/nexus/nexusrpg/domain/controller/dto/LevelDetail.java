package com.nexus.nexusrpg.domain.controller.dto;

import com.nexus.nexusrpg.domain.model.enums.LevelLabel;

import java.math.BigDecimal;

public record LevelDetail(
        Long id,
        LevelLabel name,
        String description,
        BigDecimal xpRequired
) {}
