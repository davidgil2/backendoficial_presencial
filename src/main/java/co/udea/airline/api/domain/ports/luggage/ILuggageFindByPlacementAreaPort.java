package co.udea.airline.api.domain.ports.luggage;

import java.util.List;

import co.udea.airline.api.domain.models.luggage.LuggageResponse;

public interface ILuggageFindByPlacementAreaPort {

    List<LuggageResponse> findByPlacementArea(Long placementAreaId);
    
}
