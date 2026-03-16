package com.nexus.nexusrpg.planet;

import com.nexus.nexusrpg.model.entity.Planet;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Planeta Vetorial — Vetores e Matrizes
 */
public class Vetorial extends Planet implements PlanetBehavior {

    public Vetorial() { super(); }

    public Vetorial(Planet p) {
        this.setId(p.getId());
        this.setName(p.getName());
        this.setDescription(p.getDescription());
        this.setPlanetPrerequisite(p.getPlanetPrerequisite());
    }

    @Override
    public String getTopic() { return "Vetores e Matrizes"; }

    @Override
    public String getGuide() {
        return "Vetorial contém cristais indexados: exemplifique arrays e matrizes, acesso por índice e operações comuns (iterar, buscar, modificar).";
    }

    @Override
    public List<Challenge> getChallenges() {
        return Arrays.asList(
                new Challenge("V1", "Acesso por Índice", "Extrair cristais de posições específicas sem se perder nas minas.", "EASY", 80),
                new Challenge("V2", "Matriz Multidimensional", "Mapear uma matriz de cristais e extrair uma coluna inteira.", "HARD", 200)
        );
    }

    @Override
    public boolean canExtract(String resourceName, Map<String, Object> context) {
        // Vetorial permite extrair 'Cristal Índice' se o índice estiver dentro dos limites
        if (!"Cristal Índice".equalsIgnoreCase(resourceName)) return false;
        Integer index = (Integer) context.getOrDefault("index", 0);
        Integer size = (Integer) context.getOrDefault("size", 10);
        return index >= 0 && index < size;
    }

    @Override
    public int simulateExtraction(String resourceName, Map<String, Object> context) {
        Integer index = (Integer) context.getOrDefault("index", 0);
        return 20 + Math.max(0, (index % 5));
    }
}
