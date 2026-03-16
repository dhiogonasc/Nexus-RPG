package com.nexus.nexusrpg.planet;

import com.nexus.nexusrpg.model.entity.Planet;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Planeta Ciclos — Laços de Repetição
 */
public class Ciclos extends Planet implements PlanetBehavior {

    public Ciclos() { super(); }

    public Ciclos(Planet p) {
        this.setId(p.getId());
        this.setName(p.getName());
        this.setDescription(p.getDescription());
        this.setPlanetPrerequisite(p.getPlanetPrerequisite());
    }

    @Override
    public String getTopic() { return "Laços de Repetição (ENQUANTO / PARA)"; }

    @Override
    public String getGuide() {
        return "Ciclos é um bioma onde ações se repetem: introduza 'para' e 'enquanto' com exemplos de automação de coleta até que a condição seja falsa.";
    }

    @Override
    public List<Challenge> getChallenges() {
        return Arrays.asList(
                new Challenge("C1", "Colheita em Loop", "Programar um laço que colecione frutos enquanto o solo for fértil.", "MEDIUM", 100),
                new Challenge("C2", "Loop Otimizado", "Usar estruturas 'para' para coletar em intervalos regulares sem desperdício.", "HARD", 180)
        );
    }

    @Override
    public boolean canExtract(String resourceName, Map<String, Object> context) {
        // Se o solo estiver fértil, pode extrair frutos em série
        Boolean fertile = (Boolean) context.getOrDefault("soilFertile", Boolean.FALSE);
        return fertile && resourceName.toLowerCase().contains("fruto");
    }

    @Override
    public int simulateExtraction(String resourceName, Map<String, Object> context) {
        Integer iterations = (Integer) context.getOrDefault("iterations", 1);
        int per = 10; // xp por item
        return per * Math.max(1, iterations);
    }
}
