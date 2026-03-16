package com.nexus.nexusrpg.model.entity;

import com.nexus.nexusrpg.model.enums.MissionStatus;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_mission")
public class UserMission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mission_id", nullable = false)
    private Mission mission;

    @Builder.Default
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, columnDefinition = "mission_status")
    private MissionStatus status = MissionStatus.IN_PROGRESS;

    @Builder.Default
    @Column(name = "best_result", nullable = false)
    private BigDecimal bestResult = new BigDecimal(0);
}
