package co.udea.airline.api.domain.ports.luggage;


import co.udea.airline.api.domain.models.luggage.LuggageRequest;
import co.udea.airline.api.domain.models.luggage.LuggageResponse;
import co.udea.airline.api.infraestructure.exceptions.RestException;

public interface ILuggageSavePort {
    
    LuggageResponse save(LuggageRequest luggageRequest) throws RestException;
}
