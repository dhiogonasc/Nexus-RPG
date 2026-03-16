package com.nexus.nexusrpg.model.entity;

import com.nexus.nexusrpg.model.enums.AchievementScope;
import com.nexus.nexusrpg.model.enums.AchievementType;
import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "achievement")
public class Achievement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "\"name\"", nullable = false)
    private String name;

    @Column(name = "\"description\"", columnDefinition = "TEXT")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "\"type\"", nullable = false)
    private AchievementType type;

    @Enumerated(EnumType.STRING)
    @Column(name = "\"scope\"", nullable = false)
    private AchievementScope scope;

    @Builder.Default
    @Column(name = "\"bonus_xp\"", nullable = false)
    private int bonusXp = 0;
}
