package com.nexus.nexusrpg.domain.controller.dto;

import com.nexus.nexusrpg.common.dto.EntityDetail;
import com.nexus.nexusrpg.common.dto.EntityDynamicReference;
import com.nexus.nexusrpg.domain.controller.dto.response.QuestionDTO;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.util.List;

@SuperBuilder
public class MissionDetail extends EntityDetail {
    private final String content;
    private final List<QuestionDTO> questions;
    private final long xpBonus;
    private final BigDecimal bestResult;
    private final EntityDynamicReference planet;
}