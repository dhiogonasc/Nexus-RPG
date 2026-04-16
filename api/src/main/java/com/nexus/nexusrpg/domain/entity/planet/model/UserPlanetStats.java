package com.nexus.nexusrpg.domain.entity.planet.model;

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

import static com.nexus.nexusrpg.common.entity.enums.EntityStatus.LOCKED;
import static com.nexus.nexusrpg.common.entity.enums.EntityStatus.UNLOCKED;
import static java.math.RoundingMode.HALF_UP;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class UserPlanetStats implements Progressable {

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

    public void unlock() {
        this.status = UNLOCKED;
        this.isAccessible = true;
        this.isCurrent = true;
    }

    public void complete() {
        this.status = EntityStatus.COMPLETED;
        this.isCurrent = false;
    }

    public void updateProgress(int completedMissions, int totalMissions) {

        if (totalMissions == 0) return;

        this.progress = BigDecimal.valueOf(completedMissions)
                .divide(BigDecimal.valueOf(totalMissions), 2, HALF_UP)
                .multiply(BigDecimal.valueOf(100));
    }
}