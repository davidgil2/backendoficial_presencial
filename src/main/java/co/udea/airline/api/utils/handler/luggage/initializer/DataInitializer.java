package co.udea.airline.api.utils.handler.luggage.initializer;

import org.springframework.stereotype.Component;

import co.udea.airline.api.model.jpa.entities.PlacementAreaEntity;
import co.udea.airline.api.repositories.PlacementAreaRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DataInitializer {

    private final PlacementAreaRepository placementAreaRepository;

    // This method initializes the placement areas content in the database
    @PostConstruct
    public void init() {
        if (placementAreaRepository.count() == 0) {

            placementAreaRepository.save(new PlacementAreaEntity("EQUIPAJE DE MANO"));
            placementAreaRepository.save(new PlacementAreaEntity("EQUIPAJE DE BODEGA"));
            placementAreaRepository.save(new PlacementAreaEntity("EQUIPAJE DE CABINA"));
        }

    }

}
