package com.nexus.nexusrpg.domain.entity.resource.model;

import com.nexus.nexusrpg.domain.user.model.User;
import jakarta.persistence.*;
import lombok.*;

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

    @Embedded
    @Builder.Default
    private UserResourceStats stats = new UserResourceStats();

    public static UserResource initialize(User user, Resource resource){

        var initialStats = UserResourceStats.builder()
                .collected(false)
                .build();

        return UserResource.builder()
                .user(user)
                .resource(resource)
                .stats(initialStats)
                .build();
    }
}
