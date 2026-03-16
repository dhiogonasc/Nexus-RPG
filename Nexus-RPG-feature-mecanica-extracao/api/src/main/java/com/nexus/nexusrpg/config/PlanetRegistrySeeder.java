package com.nexus.nexusrpg.config;

import com.nexus.nexusrpg.model.entity.Planet;
import com.nexus.nexusrpg.planet.Bifurca;
import com.nexus.nexusrpg.planet.Ciclos;
import com.nexus.nexusrpg.planet.PlanetBehavior;
import com.nexus.nexusrpg.planet.Variabilis;
import com.nexus.nexusrpg.planet.Vetorial;
import com.nexus.nexusrpg.repository.PlanetRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Componente que registra os comportamentos de cada planeta lendo as entidades já populadas no banco.
 * Não altera dados no banco; apenas mapeia regras em memória.
 */
@Component
public class PlanetRegistrySeeder {

    private final PlanetRepository planetRepository;
    private final PlanetRuleRegistry registry;

    public PlanetRegistrySeeder(PlanetRepository planetRepository, PlanetRuleRegistry registry) {
        this.planetRepository = planetRepository;
        this.registry = registry;
    }

    @PostConstruct
    public void registerPlanetBehaviors() {
        List<Planet> planets = planetRepository.findAll();
        for (Planet p : planets) {
            String name = p.getName();
            PlanetBehavior behavior = null;
            if ("Variabilis".equalsIgnoreCase(name)) {
                behavior = new Variabilis(p);
            } else if ("Bifurca".equalsIgnoreCase(name)) {
                behavior = new Bifurca(p);
            } else if ("Ciclos".equalsIgnoreCase(name)) {
                behavior = new Ciclos(p);
            } else if ("Vetorial".equalsIgnoreCase(name)) {
                behavior = new Vetorial(p);
            }

            if (behavior != null) {
                registry.register(p.getName(), behavior);
            }
        }
    }
}
