package com.nexus.nexusrpg.domain.model;

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
@Table(name = "mission", uniqueConstraints = {
        @UniqueConstraint(name = "uk_mission_planet_name", columnNames = {"planet_id", "\"name\""}),
        @UniqueConstraint(name = "uk_mission_planet_order", columnNames = {"planet_id", "\"order\""})
})
public class Mission implements Orientable, Rewardable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "planet_id", nullable = false)
    private Planet planet;

    @Column(name = "\"name\"", nullable = false, unique = true)
    private String name;

    @Column(name = "\"description\"", columnDefinition = "TEXT", nullable = false)
    private String description;

    @Column(name = "\"content\"", columnDefinition = "TEXT", nullable = false)
    private String content;

    @Column(name = "\"order\"", nullable = false, unique = true)
    private int order;

    @Column(name = "xp_bonus", nullable = false, columnDefinition = "xp")
    private long xpBonus;

    @OneToMany(mappedBy = "mission", fetch = FetchType.LAZY)
    @OrderBy("order ASC")
    private List<Question> questions;

    @Override
    public boolean isLast() {
        return this.planet.getMissions().size() == this.getOrder();
    }
}
