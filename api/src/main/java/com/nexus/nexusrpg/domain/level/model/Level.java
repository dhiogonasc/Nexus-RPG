package com.nexus.nexusrpg.domain.level.model;

import com.nexus.nexusrpg.domain.level.model.enums.LevelLabel;
import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "\"level\"")
public class Level {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "name", nullable = false, unique = true, columnDefinition = "level_label")
    private LevelLabel name;

    @Column(name = "description")
    private String description;

    @Column(name = "order", nullable = false)
    private int order;

    @Column(name = "xp_required", nullable = false, columnDefinition = "xp")
    private long xpRequired;
}
