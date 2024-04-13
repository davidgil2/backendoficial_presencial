package co.udea.airline.api.model.jpa.ports.placementarea;


import java.util.List;
import java.util.Optional;

import co.udea.airline.api.model.jpa.models.placementArea.PlacementAreaResponse;


public interface IPlacementAreaFindPort {

    List<PlacementAreaResponse> findAll();

    Optional<PlacementAreaResponse> findById(Long id);
    
}
