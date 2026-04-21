package com.nexus.nexusrpg.domain.model;

import com.nexus.nexusrpg.domain.entity.question.model.Question;
import com.nexus.nexusrpg.domain.model.enums.PlanetLabel;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "mission", uniqueConstraints = {
        @UniqueConstraint(name = "uk_mission_planet_name", columnNames = {"planet_id", "\"name\""}),
        @UniqueConstraint(name = "uk_mission_planet_order", columnNames = {"planet_id", "\"order\""})
})
public class Mission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "planet_id", nullable = false)
    private Planet planet;

    @Column(name = "\"name\"", nullable = false, unique = true)
    private String name;

    @Column(name = "\"description\"", columnDefinition = "TEXT")
    private String description;

    @Column(name = "\"order\"", nullable = false, unique = true)
    private int order;


    @Column(name = "xp_bonus", nullable = false, columnDefinition = "xp")
    private long xpBonus;

    @OneToMany(mappedBy = "mission", fetch = FetchType.LAZY)
    @OrderBy("order ASC")
    private List<Question> questions;
}
