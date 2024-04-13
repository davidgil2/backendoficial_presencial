package co.udea.airline.api.model.jpa.ports.luggage;

import co.udea.airline.api.model.jpa.models.luggage.LuggageRequest;
import co.udea.airline.api.model.jpa.models.luggage.LuggageResponse;
import co.udea.airline.api.utils.exceptions.RestException;

public interface ILuggageSavePort {
    
    LuggageResponse save(LuggageRequest luggageRequest) throws RestException;
}
