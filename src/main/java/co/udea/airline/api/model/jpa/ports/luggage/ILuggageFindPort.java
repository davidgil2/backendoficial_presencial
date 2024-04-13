package co.udea.airline.api.model.jpa.ports.luggage;

import java.util.List;
import java.util.Optional;

import co.udea.airline.api.model.jpa.models.luggage.LuggageResponse;


public interface ILuggageFindPort {

    List<LuggageResponse> findAll();

    Optional<LuggageResponse> findById(Long id);

}
