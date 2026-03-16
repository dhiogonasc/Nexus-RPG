package com.nexus.nexusrpg.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "\"question\"", uniqueConstraints = {
        @UniqueConstraint(name = "uk_question_mission_order", columnNames = {"mission_id", "\"order\""})
})
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mission_id", nullable = false)
    private Mission mission;

    @Column(name = "\"description\"", nullable = false, columnDefinition = "TEXT")
    private String description;

    @Column(name = "\"code_snippet\"", nullable = false, columnDefinition = "TEXT")
    private String codeSnippet;

    @Column(name = "\"order\"", nullable = false)
    private int order;
}
