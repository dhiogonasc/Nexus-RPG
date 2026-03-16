package com.nexus.nexusrpg.model.entity;

import com.nexus.nexusrpg.model.enums.DifficultyLevel;
import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "mission")
public class Mission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "planet_id", nullable = false)
    private Planet planet;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "order", nullable = false)
    private int order;

    @Enumerated(EnumType.STRING)
    @Column(name = "difficulty", nullable = false)
    private DifficultyLevel difficulty;

    @Column(name = "xp_reward", nullable = false)
    private int xpReward;
}
