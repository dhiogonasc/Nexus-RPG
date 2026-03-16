package com.nexus.nexusrpg.model.relation;

import com.nexus.nexusrpg.model.entity.Level;
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
public class UserStat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false, unique = true, referencedColumnName = "id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "level_id", nullable = false, referencedColumnName = "id")
    private Level level;

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
