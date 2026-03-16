package com.nexus.nexusrpg.model.entity;

import com.nexus.nexusrpg.model.relation.UserStat;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "level")
public class Level {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "number", nullable = false, unique = true)
    int number;

    @Column(name = "xp_required", nullable = false)
    int xpRequired;
}
