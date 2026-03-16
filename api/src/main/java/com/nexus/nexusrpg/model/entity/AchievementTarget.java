package com.nexus.nexusrpg.model.entity;

import com.nexus.nexusrpg.model.enums.EntityType;
import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@IdClass(AchievementTargetId.class)
@Table(name = "achievement_target")
public class AchievementTarget {

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "achievement_id", nullable = false)
    private Achievement achievement;

    @Id
    @Enumerated(EnumType.STRING)
    @Column(name = "entity", columnDefinition = "entity_type")
    private EntityType entity;

    @Id
    @Column(name = "entity_id", nullable = false)
    private Long entityId;
}
