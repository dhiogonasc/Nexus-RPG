package com.nexus.nexusrpg.config;

import com.nexus.nexusrpg.planet.PlanetBehavior;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class PlanetRuleRegistry {

    private final Map<String, PlanetBehavior> registry = new ConcurrentHashMap<>();

    public void register(String planetName, PlanetBehavior behavior) {
        registry.put(planetName, behavior);
    }

    public Optional<PlanetBehavior> get(String planetName) {
        return Optional.ofNullable(registry.get(planetName));
    }
}
