package com.nexus.nexusrpg.model.entity;

import com.nexus.nexusrpg.model.enums.EntityType;
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
