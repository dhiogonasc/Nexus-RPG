package com.nexus.nexusrpg.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "\"resource\"")
public class Resource {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "planet_id", nullable = false, unique = true)
    private Planet planet;

    @Column(name = "\"name\"", nullable = false, unique = true)
    private String name;

    @Column(name = "\"description\"", columnDefinition = "TEXT")
    private String description;

    @Column(name = "xp_bonus", nullable = false, columnDefinition = "xp")
    private long xpBonus;
}
