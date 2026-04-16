package com.nexus.nexusrpg.domain.entity.resource.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class UserResourceStats {

    @Column(name = "\"collected_at\"")
    private LocalDateTime collectedAt;

    @Builder.Default
    @Column(name = "\"is_collected\"", nullable = false)
    private boolean collected = false;

    public void collect(){
        this.setCollected(true);
        this.setCollectedAt(LocalDateTime.now());
    }
}
