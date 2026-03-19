package com.nexus.nexusrpg.model.entity;


import com.nexus.nexusrpg.model.enums.PlanetLabel;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "\"planet\"")
public class Planet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "\"name\"", nullable = false, unique = true, columnDefinition = "planet_label")
    private PlanetLabel name;

    @Column(name = "\"description\"", columnDefinition = "TEXT")
    private String description;

    @Column(name = "\"order\"", nullable = false, unique = true)
    private int order;

    @Column(name = "xp_bonus", nullable = false, columnDefinition = "xp")
    private long xpBonus; 

    @OneToMany(mappedBy = "planet")
    private List<Mission> missions;
}
