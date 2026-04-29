package com.nexus.nexusrpg.user.model;

import com.nexus.nexusrpg.domain.model.Level;
import com.nexus.nexusrpg.domain.model.Levelable;
import com.nexus.nexusrpg.domain.model.relation.UMission;
import com.nexus.nexusrpg.domain.model.relation.UPlanet;
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
@Table(name = "\"user\"")
public class User implements Levelable {

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
    @Column(name = "\"xp\"", nullable = false, columnDefinition = "xp")
    private long xp = 0;

    @Builder.Default
    @Column(name = "\"oxygen\"", nullable = false, columnDefinition = "oxygen")
    private int oxygen = 10;

    @OneToMany(mappedBy = "user")
    List<UPlanet> planets;

    @OneToMany(mappedBy = "user")
    List<UMission> missions;

    public void addXp(long xp) {
        this.xp += xp;
    }

    @Override
    public void up(Level next) {
        if (!this.level.isLast()){
            this.level = next;
        }
    }
}
