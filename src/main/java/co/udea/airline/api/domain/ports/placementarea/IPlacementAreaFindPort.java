package co.udea.airline.api.domain.ports.placementarea;

import java.util.List;
import java.util.Optional;

import co.udea.airline.api.domain.models.placementArea.PlacementAreaResponse;

public interface IPlacementAreaFindPort {

    List<PlacementAreaResponse> findAll();

    Optional<PlacementAreaResponse> findById(Long id);
    
}
