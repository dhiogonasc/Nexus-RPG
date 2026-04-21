package com.nexus.nexusrpg.domain.entity.question.model;

import com.nexus.nexusrpg.domain.entity.alternative.model.Alternative;
import com.nexus.nexusrpg.domain.model.Mission;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "\"question\"", uniqueConstraints = {
        @UniqueConstraint(name = "uk_question_mission_order", columnNames = {"mission_id", "order"})
})
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mission_id", nullable = false)
    private Mission mission;

    @Column(name = "\"content\"", nullable = false, columnDefinition = "text")
    private String content;

    @Column(name = "\"code_snippet\"", columnDefinition = "text")
    private String codeSnippet;

    @Column(name = "\"order\"", nullable = false)
    private Integer order;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Alternative> alternatives;

    public Alternative getCorrectAlternative() {
        return this.alternatives.stream()
                .filter(Alternative::getIsCorrect)
                .findFirst()
                .orElse(null);
    }
}