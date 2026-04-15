package com.nexus.nexusrpg.domain.user.model.relation;

import com.nexus.nexusrpg.domain.entity.resource.model.Resource;
import com.nexus.nexusrpg.domain.user.model.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "\"user_resource\"", uniqueConstraints = {
        @UniqueConstraint(name = "uk_user_resource", columnNames = {"user_id", "resource_id"})
})
public class UserResource {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "resource_id", nullable = false)
    private Resource resource;

    @Column(name = "\"collected_at\"")
    private LocalDateTime collectedAt;

    @Builder.Default
    @Column(name = "\"is_collected\"", nullable = false)
    private boolean collected = false;

    public static UserResource initialize(User user, Resource resource){

        return UserResource.builder()
                .user(user)
                .resource(resource)
                .collected(false)
                .build();
    }

    public void collect(){
        this.setCollected(true);
        this.setCollectedAt(LocalDateTime.now());
    }
}
