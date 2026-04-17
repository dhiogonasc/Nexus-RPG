package com.nexus.nexusrpg.domain.entity.mission.model;

import com.nexus.nexusrpg.common.entity.enums.EntityStatus;
import com.nexus.nexusrpg.common.entity.interfaces.Progressable;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcType;
import org.hibernate.dialect.PostgreSQLEnumJdbcType;

import java.math.BigDecimal;

import static com.nexus.nexusrpg.common.entity.enums.EntityStatus.*;
import static java.math.RoundingMode.HALF_UP;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class UserMissionStats implements Progressable {

    private static final BigDecimal MISSION_COMPLETION_THRESHOLD = BigDecimal.valueOf(7);

    @Builder.Default
    @Enumerated(EnumType.STRING)
    @JdbcType(PostgreSQLEnumJdbcType.class)
    @Column(name = "\"status\"", nullable = false, columnDefinition = "entity_status")
    private EntityStatus status = LOCKED;

    @Builder.Default
    @Column(name = "\"is_accessible\"", nullable = false)
    private Boolean isAccessible = false;

    @Builder.Default
    @Column(name = "\"is_current\"", nullable = false)
    private Boolean isCurrent = false;

    @Builder.Default
    @Column(name = "\"progress\"", nullable = false, columnDefinition = "progress")
    private BigDecimal progress = BigDecimal.ZERO;

    @Builder.Default
    @Column(name = "\"best_result\"", nullable = false, columnDefinition = "score")
    private BigDecimal bestResult = BigDecimal.ZERO;

    public void unlock() {
        this.status = UNLOCKED;
        this.isAccessible = true;
        this.isCurrent = true;
    }

    public void complete() {
        this.status = COMPLETED;
        this.isCurrent = false;
    }

    public void updateProgress(long answeredQuestions, long totalQuestions) {

        if (totalQuestions == 0) return;

        this.progress = BigDecimal.valueOf(answeredQuestions)
                .divide(BigDecimal.valueOf(totalQuestions), 2, HALF_UP)
                .multiply(BigDecimal.valueOf(100));
    }

    public void updateBestResult(BigDecimal currentResult) {

        if (currentResult == null) return;

        if (this.bestResult == null || currentResult.compareTo(this.bestResult) > 0) {
            this.bestResult = currentResult;
        }

        if (this.status != COMPLETED && currentResult.compareTo(MISSION_COMPLETION_THRESHOLD) >= 0) {
            this.complete();
        }
    }
}
