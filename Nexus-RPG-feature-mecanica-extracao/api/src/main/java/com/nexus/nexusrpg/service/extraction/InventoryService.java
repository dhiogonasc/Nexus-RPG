package com.nexus.nexusrpg.service.extraction;

import com.nexus.nexusrpg.model.entity.Alternative;
import com.nexus.nexusrpg.model.entity.Resource;
import com.nexus.nexusrpg.model.entity.UserResource;
import com.nexus.nexusrpg.repository.ResourceRepository;
import com.nexus.nexusrpg.repository.UserResourceRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InventoryService {

    private final UserResourceRepository userResourceRepository;
    private final ResourceRepository resourceRepository;

    public InventoryService(UserResourceRepository userResourceRepository, ResourceRepository resourceRepository) {
        this.userResourceRepository = userResourceRepository;
        this.resourceRepository = resourceRepository;
    }

    public String storeLoot(Long userId, Alternative alternative) {
        try {

            Long planetId = alternative.getQuestion().getMission().getPlanet().getId();

            Resource extractedResource = resourceRepository.findByPlanetId(planetId)
                    .stream()
                    .findFirst()
                    .orElseThrow(() -> new RuntimeException("Planeta sem recursos catalogados."));

            Optional<UserResource> existingItem = userResourceRepository.findByUserIdAndResourceId(
                    userId, 
                    extractedResource.getId()
            );

            if (existingItem.isPresent()) {

                UserResource item = existingItem.get();
                item.setQuantity(item.getQuantity() + 1);
                userResourceRepository.save(item);

            } else {

                UserResource newItem = new UserResource();
                newItem.setUserId(userId);
                newItem.setResource(extractedResource);
                newItem.setQuantity(1);

                userResourceRepository.save(newItem);
            }

            return extractedResource.getName();

        } catch (Exception e) {

            return "Fragmento Lógico Genérico";

        }
    }
}