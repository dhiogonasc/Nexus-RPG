package com.nexus.nexusrpg.model.relation;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "\"user_mission_attempt\"")
public class UserMissionAttempt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_mission_id")
    private UserMission userMission;

    @CreationTimestamp
    @Column(name = "start_at", nullable = false, updatable = false)
    private LocalDateTime startAt;

    @Column(name = "end_at")
    private LocalDateTime endAt;

    @Builder.Default
    @Column(
            name = "\"result\"",
            nullable = false,
            precision = 5,
            scale = 2,
            columnDefinition = "score DEFAULT 0"
    )
    private BigDecimal result = BigDecimal.ZERO;
}
