package co.udea.airline.api.model.jpa.ports.luggage;

import java.util.List;

import co.udea.airline.api.model.jpa.models.luggage.LuggageResponse;

public interface ILuggageFindByPlacementAreaPort {

    List<LuggageResponse> findByPlacementArea(Long placementAreaId);
    
}
