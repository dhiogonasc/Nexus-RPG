package com.nexus.nexusrpg.planet;

import java.util.List;
import java.util.Map;

/**
 * Contrato para comportamento de planetas (regras de jogo).
 */
public interface PlanetBehavior {
    String getTopic();

    /**
     * Texto explicativo / tutorial sobre a regra do planeta.
     */
    String getGuide();

    /**
     * Lista de desafios disponíveis no planeta (não persistidos).
     */
    List<Challenge> getChallenges();

    /**
     * Verifica se um recurso pode ser extraído dado o contexto fornecido.
     * @param resourceName nome do recurso
     * @param context mapa com informações de ambiente (ex.: "isRaining": true)
     */
    boolean canExtract(String resourceName, Map<String, Object> context);

    /**
     * Simula a extração de um recurso e retorna XP ganho (simplificado).
     */
    int simulateExtraction(String resourceName, Map<String, Object> context);
}
