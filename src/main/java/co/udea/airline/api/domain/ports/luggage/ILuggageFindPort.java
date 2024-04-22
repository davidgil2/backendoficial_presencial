package co.udea.airline.api.domain.ports.luggage;

import java.util.List;
import java.util.Optional;

import co.udea.airline.api.domain.models.luggage.LuggageResponse;

public interface ILuggageFindPort {

    List<LuggageResponse> findAll();

    Optional<LuggageResponse> findById(Long id);

}
