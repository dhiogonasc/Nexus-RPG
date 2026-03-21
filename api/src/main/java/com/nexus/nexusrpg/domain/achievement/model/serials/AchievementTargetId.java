package com.nexus.nexusrpg.domain.achievement.model.serials;

import com.nexus.nexusrpg.common.enums.EntityType;
import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AchievementTargetId implements Serializable {

    private Long achievement;
    private EntityType entity;
    private Long entityId;
}
