package com.nexus.nexusrpg.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_stat")
public class UserStat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "level_id", nullable = false)
    private Level level;

    @Builder.Default
    @Column(name = "xp_current", nullable = false)
    int xpCurrent = 0;

    @Builder.Default
    @Column(name = "streak_current", nullable = false)
    int streakCurrent = 0;

    @CreationTimestamp
    @Column(name = "last_access", nullable = false)
    LocalDateTime lastAccess;
}
