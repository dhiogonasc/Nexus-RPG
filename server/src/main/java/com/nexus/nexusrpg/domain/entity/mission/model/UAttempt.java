package com.nexus.nexusrpg.domain.entity.mission.model;

import com.nexus.nexusrpg.domain.model.relation.UMission;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static com.nexus.nexusrpg.domain.model.enums.EntityStatus.COMPLETED;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "\"user_mission_attempt\"")
public class UAttempt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_mission_id", nullable = false)
    private UMission uMission;

    @CreationTimestamp
    @Column(name = "start_at", nullable = false, updatable = false)
    private LocalDateTime startAt;

    @Column(name = "end_at")
    private LocalDateTime endAt;

    @Builder.Default
    @Column(name = "\"result\"", nullable = false, columnDefinition = "score")
    private BigDecimal result = BigDecimal.ZERO;

    @OneToMany(mappedBy = "attempt", cascade = CascadeType.ALL)
    private List<UserResponse> responses;

    public void finish(BigDecimal currentResult) {
        this.endAt = LocalDateTime.now();
        this.result = currentResult;

        if (this.uMission != null) {
            var stats = this.uMission.getExecution();
            var completed = stats.getStatus() == COMPLETED;

            stats.updateBestResult(currentResult);

            if (!completed && stats.getStatus() == COMPLETED) {
                var user = this.uMission.getUser();
                var mission = this.uMission.getMission();
                user.addXp(mission.getXpBonus());
            }
        }
    }
}
