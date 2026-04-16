package com.nexus.nexusrpg.domain.user.model;

import com.nexus.nexusrpg.domain.entity.level.model.Level;
import com.nexus.nexusrpg.domain.entity.mission.model.UserMission;
import com.nexus.nexusrpg.domain.entity.planet.model.UserPlanet;
import com.nexus.nexusrpg.domain.entity.resource.model.UserResource;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "\"user\"")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "\"username\"", nullable = false)
    private String username;

    @Column(name = "\"email\"", nullable = false, unique = true)
    private String email;

    @Column(name = "\"password\"", nullable = false)
    private String password;

    @ManyToOne
    @JoinColumn(name = "level_id", nullable = false)
    private Level level;

    @Builder.Default
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UserPlanet> planets = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UserMission> missions = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UserResource> resources = new ArrayList<>();

    @Builder.Default
    @Column(name = "\"xp\"", nullable = false, columnDefinition = "xp")
    private long xp = 0;

    @Builder.Default
    @Column(name = "\"oxygen\"", nullable = false, columnDefinition = "oxygen")
    private int oxygen = 10;

    public void fillOxygen(){
        this.oxygen = 10;
    }

    public void consumeOxygen(){
        this.oxygen -= 1;
    }
}
