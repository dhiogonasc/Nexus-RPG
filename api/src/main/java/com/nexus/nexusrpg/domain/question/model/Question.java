package com.nexus.nexusrpg.domain.question.model;

import com.nexus.nexusrpg.domain.mission.model.Mission;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "\"dto\"", uniqueConstraints = {
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

    @Column(name = "\"code_snippet\"", columnDefinition = "TEXT")
    private String codeSnippet;

    @Column(name = "\"order\"", nullable = false)
    private int order;

    @OneToMany(mappedBy = "dto")
    private List<Alternative> alternatives;
}
