package com.nexus.nexusrpg.domain.model.relation;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static jakarta.persistence.FetchType.LAZY;
import static jakarta.persistence.GenerationType.IDENTITY;
import static java.math.BigDecimal.ZERO;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "\"attempt\"")
public class Attempt {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "user_mission_id", nullable = false)
    private UMission mission;

    @Builder.Default
    @Column(name = "start_at", nullable = false)
    private LocalDateTime startAt = LocalDateTime.now();

    @Column(name = "end_at")
    private LocalDateTime endAt;

    @Builder.Default
    @Column(nullable = false, columnDefinition = "score")
    private BigDecimal result = ZERO;

    @OneToMany(mappedBy = "attempt", cascade = CascadeType.ALL)
    private List<Response> responses;
}
