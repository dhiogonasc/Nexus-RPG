package com.nexus.nexusrpg.domain.entity.mission.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static com.nexus.nexusrpg.common.entity.enums.EntityStatus.COMPLETED;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "\"user_mission_attempt\"")
public class UserAttempt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_mission_id", nullable = false)
    private UserMission userMission;

    @CreationTimestamp
    @Column(name = "start_at", nullable = false, updatable = false)
    private LocalDateTime startAt;

    @Column(name = "end_at")
    private LocalDateTime endAt;

    @Builder.Default
    @Column(name = "\"result\"", nullable = false, columnDefinition = "score")
    private BigDecimal result = BigDecimal.ZERO;

    public void finish(BigDecimal currentResult) {

        this.endAt = LocalDateTime.now();
        this.result = currentResult;

        if (this.userMission != null) {
            var user = this.userMission.getUser();
            var stats = this.userMission.getStats();

            var missionCompleted = stats.getStatus() == COMPLETED;

            stats.updateBestResult(currentResult);

            if (!missionCompleted && stats.getStatus() == COMPLETED) {
                long xpBonus = this.userMission.getMission().getXpBonus();
                user.addXp(xpBonus);
            }
        }
    }
}
