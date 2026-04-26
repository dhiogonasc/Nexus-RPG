package com.nexus.nexusrpg.domain.model.relation;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.FetchType.LAZY;
import static jakarta.persistence.GenerationType.IDENTITY;
import static java.math.RoundingMode.HALF_UP;

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
    private UMission uMission;

    @Builder.Default
    @Column(name = "start_at", nullable = false)
    private LocalDateTime startAt = LocalDateTime.now();

    @Column(name = "end_at")
    private LocalDateTime endAt;

    @Column(nullable = false, columnDefinition = "score")
    private BigDecimal result;

    @Builder.Default
    @OneToMany(mappedBy = "attempt", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Answer> responses = new java.util.ArrayList<>();

    public void finish(List<Answer> responses) {

        if (this.responses == null) {
            this.responses = new ArrayList<>();
        }

        this.responses.clear();
        this.responses.addAll(responses);

        long correctCount = responses.stream()
                .filter(Answer::isHit)
                .count();

        this.result = BigDecimal.valueOf(correctCount)
                .multiply(BigDecimal.valueOf(100))
                .divide(BigDecimal.valueOf(responses.size()), 2, HALF_UP);

        this.endAt = LocalDateTime.now();
    }
}
