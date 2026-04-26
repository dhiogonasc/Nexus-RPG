package com.nexus.nexusrpg.domain.controller.dto;

import com.nexus.nexusrpg.common.dto.EntityDetail;
import com.nexus.nexusrpg.common.dto.EntityDynamicReference;
import com.nexus.nexusrpg.domain.controller.dto.attempt.QuestionDTO;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.util.List;

@Getter
@SuperBuilder
public class MissionDetail extends EntityDetail {
    private final String content;
    private final List<QuestionDTO> questions;
    private final long xpBonus;
    private final BigDecimal bestResult;
    private final EntityDynamicReference planet;
}