package com.nexus.nexusrpg.model.entity;

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

    @Column(name = "\"name\"", nullable = false, unique = true)
    private String name;

    @Column(name = "\"description\"", columnDefinition = "TEXT")
    private String description;

    @Column(name = "\"order\"", nullable = false, unique = true)
    private int order;

    @OneToMany(mappedBy = "planet")
    private List<Mission> missions;
}
