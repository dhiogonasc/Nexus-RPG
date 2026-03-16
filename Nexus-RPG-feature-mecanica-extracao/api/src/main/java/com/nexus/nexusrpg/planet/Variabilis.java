package com.nexus.nexusrpg.planet;

import com.nexus.nexusrpg.model.entity.Planet;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Planeta Variabilis — Variáveis e Tipos de Dados
 */
public class Variabilis extends Planet implements PlanetBehavior {

    public Variabilis() { super(); }

    public Variabilis(Planet p) {
        this.setId(p.getId());
        this.setName(p.getName());
        this.setDescription(p.getDescription());
        this.setPlanetPrerequisite(p.getPlanetPrerequisite());
    }

    @Override
    public String getTopic() { return "Variáveis e Tipos de Dados"; }

    @Override
    public String getGuide() {
        return "Neste planeta o jogador aprende sobre tipos primitivos: inteiro, real, caractere, cadeia e booleano. Use coletas para exemplificar conversões e validações de tipo.";
    }

    @Override
    public List<Challenge> getChallenges() {
        return Collections.singletonList(
                new Challenge("V1", "Coleta Tipada", "Coletar seiva e classificá-la pelo tipo correto.", "EASY", 50)
        );
    }

    @Override
    public boolean canExtract(String resourceName, Map<String, Object> context) {
        // Variabilis permite extrair 'Seiva Bruta' sempre; outros recursos não.
        return "Seiva Bruta".equalsIgnoreCase(resourceName) || "Folha Gravada".equalsIgnoreCase(resourceName);
    }

    @Override
    public int simulateExtraction(String resourceName, Map<String, Object> context) {
        // Simples: inteiros dão 10xp, reais 15xp, texto 5xp, booleano 2xp
        Map<String,Integer> mapping = new HashMap<>();
        mapping.put("inteiro", 10);
        mapping.put("real", 15);
        mapping.put("texto", 5);
        mapping.put("booleano", 2);

        String type = (String) context.getOrDefault("valueType", "inteiro");
        return mapping.getOrDefault(type.toLowerCase(), 5);
    }
}
