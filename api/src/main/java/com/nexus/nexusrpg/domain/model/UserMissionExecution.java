package com.nexus.nexusrpg.domain.model;

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

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class UserMissionExecution implements Progressable {

    private static final BigDecimal MISSION_COMPLETION_THRESHOLD = BigDecimal.valueOf(7);

    @Builder.Default
    @Enumerated(EnumType.STRING)
    @JdbcType(PostgreSQLEnumJdbcType.class)
    @Column(name = "\"status\"", nullable = false, columnDefinition = "entity_status")
    private EntityStatus status = LOCKED;

    @Builder.Default
    @Column(name = "\"is_current\"", nullable = false)
    private Boolean isCurrent = false;

    @Builder.Default
    @Column(name = "\"best_result\"", nullable = false, columnDefinition = "score")
    private BigDecimal bestResult = BigDecimal.ZERO;

    public void unlock() {
        this.status = UNLOCKED;
        this.isCurrent = true;
    }

    public void complete() {
        this.status = COMPLETED;
        this.isCurrent = false;
    }

    public void update(long answeredQuestions, long totalQuestions) {}

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
