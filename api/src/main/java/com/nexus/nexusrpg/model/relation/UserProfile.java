package com.nexus.nexusrpg.model.relation;

import com.nexus.nexusrpg.model.entity.Level;
import com.nexus.nexusrpg.model.entity.Mission;
import com.nexus.nexusrpg.model.entity.Planet;
import com.nexus.nexusrpg.model.entity.User;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "\"user_stat\"")
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "level_id", nullable = false)
    private Level level;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "current_planet_id")
    private Planet currentPlanet;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "current_mission_id")
    private Mission currentMission;

    @Builder.Default
    @Column(name = "\"xp_total\"", nullable = false)
    private int xpTotal = 0;

    @Builder.Default
    @Column(name = "\"streak_current\"", nullable = false)
    int streakCurrent = 0;

    @CreationTimestamp
    @Column(name = "\"last_access\"", nullable = false)
    LocalDateTime lastAccess;
}
