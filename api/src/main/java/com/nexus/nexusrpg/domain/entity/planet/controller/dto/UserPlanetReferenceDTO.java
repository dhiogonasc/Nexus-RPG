package com.nexus.nexusrpg.domain.entity.planet.controller.dto;

public record UserPlanetReferenceDTO(

        PlanetReferenceDTO planet,
        UserPlanetStatsDTO stats
) {}