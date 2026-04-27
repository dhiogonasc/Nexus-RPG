package com.nexus.nexusrpg.domain.model;

import com.nexus.nexusrpg.domain.model.enums.PlanetLabel;
import com.nexus.nexusrpg.domain.model.relation.Orientable;
import com.nexus.nexusrpg.domain.model.relation.Rewardable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "\"planet\"")
public class Planet implements Orientable, Rewardable {

    private static final int PLANETS_COUNT = PlanetLabel.values().length;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "\"name\"", nullable = false, unique = true, columnDefinition = "planet_label")
    private PlanetLabel name;

    @Column(name = "\"description\"", columnDefinition = "TEXT", nullable = false)
    private String description;

    @Column(name = "\"content\"", columnDefinition = "TEXT", nullable = false)
    private String content;

    @Column(name = "\"order\"", nullable = false, unique = true)
    private int order;

    @Column(name = "xp_bonus", nullable = false, columnDefinition = "xp")
    private long xpBonus;

    @OneToMany(mappedBy = "planet")
    private List<Mission> missions;

    @Override
    public boolean isLast() {
        return this.order == PLANETS_COUNT;
    }
}
