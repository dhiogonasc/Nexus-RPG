package com.nexus.nexusrpg.model.entity;

import com.nexus.nexusrpg.model.relation.UserResponse;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "\"question\"")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mission_id", nullable = false)
    private Mission mission;

    @Column(name = "\"description\"", columnDefinition = "TEXT")
    private String description;

    @Column(name = "\"code_snippet\"", columnDefinition = "TEXT")
    private String codeSnippet;

    @Column(name = "\"order\"", nullable = false)
    private int order;
}
