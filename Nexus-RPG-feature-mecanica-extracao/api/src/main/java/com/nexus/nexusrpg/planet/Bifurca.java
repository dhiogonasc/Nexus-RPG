package com.nexus.nexusrpg.planet;

import com.nexus.nexusrpg.model.entity.Planet;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Planeta Bifurca — Estruturas Condicionais
 */
public class Bifurca extends Planet implements PlanetBehavior {

    public Bifurca() { super(); }

    public Bifurca(Planet p) {
        this.setId(p.getId());
        this.setName(p.getName());
        this.setDescription(p.getDescription());
        this.setPlanetPrerequisite(p.getPlanetPrerequisite());
    }

    @Override
    public String getTopic() { return "Estruturas Condicionais (SE/SENAO)"; }

    @Override
    public String getGuide() {
        return "Bifurca é um planeta de decisões: mostre exemplos de 'se/então/senão' e crie cenários onde o extrator decide qual recurso coletar com base em condições (ex.: chuva).";
    }

    @Override
    public List<Challenge> getChallenges() {
        return Arrays.asList(
                new Challenge("B1", "Decisão do Clima", "Selecionar o recurso correto conforme o clima detectado.", "EASY", 60),
                new Challenge("B2", "Encadeamento Condicional", "Criar lógica com múltiplas condições para maximizar a coleta.", "MEDIUM", 100)
        );
    }

    @Override
    public boolean canExtract(String resourceName, Map<String, Object> context) {
        Boolean isRaining = (Boolean) context.getOrDefault("isRaining", Boolean.FALSE);
        if (isRaining) {
            return "Flor de Água".equalsIgnoreCase(resourceName);
        } else {
            return "Cristal de Sol".equalsIgnoreCase(resourceName) || "Folha Seca".equalsIgnoreCase(resourceName);
        }
    }

    @Override
    public int simulateExtraction(String resourceName, Map<String, Object> context) {
        Boolean isRaining = (Boolean) context.getOrDefault("isRaining", Boolean.FALSE);
        if (isRaining && "Flor de Água".equalsIgnoreCase(resourceName)) return 70;
        if (!isRaining && "Cristal de Sol".equalsIgnoreCase(resourceName)) return 50;
        return 10;
    }
}
