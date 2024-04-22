package co.udea.airline.api.application.services.luggage;

import org.springframework.stereotype.Service;

import co.udea.airline.api.domain.entities.LuggageEntity;
import co.udea.airline.api.domain.entities.PlacementAreaEntity;
import co.udea.airline.api.domain.mappers.luggage.LuggageRequestMapper;
import co.udea.airline.api.domain.mappers.luggage.LuggageResponseMapper;
import co.udea.airline.api.domain.models.luggage.LuggageRequest;
import co.udea.airline.api.domain.models.luggage.LuggageResponse;
import co.udea.airline.api.domain.ports.luggage.ILuggageSavePort;
import co.udea.airline.api.infraestructure.exceptions.NumberNotValidException;
import co.udea.airline.api.infraestructure.exceptions.RestException;
import co.udea.airline.api.infraestructure.repositories.LuggageRepository;
import co.udea.airline.api.infraestructure.repositories.PlacementAreaRepository;
import co.udea.airline.api.infraestructure.utils.validation.LuggageValidation;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
// This class is the service for the luggage save use case
public class LuggageSaveService implements ILuggageSavePort {

    private final LuggageRepository luggageRepository;
    private final PlacementAreaRepository placementAreaRepository;

    @Override
    public LuggageResponse save(LuggageRequest luggageRequest) throws RestException  {
        double[] decimals = {
                luggageRequest.getWeight(),
                luggageRequest.getHeight(),
                luggageRequest.getWidth(),
                luggageRequest.getLength()
        };

        if (!LuggageValidation.validatePositiveDecimals(decimals)) {
            throw new NumberNotValidException("Los valores numéricos deben ser mayores a 0");
        }

        if (!LuggageValidation.validateExtraCharge(luggageRequest.getExtraCharge())) {
            throw new NumberNotValidException("El valor del cargo extra debe ser mayor o igual a 0");
        }

        if (!LuggageValidation.validateQuantity(luggageRequest.getQuantity())) {
            throw new NumberNotValidException("La cantidad debe ser mayor a 0");
        }

        // search for the placement area
        PlacementAreaEntity placementArea = placementAreaRepository.findById(luggageRequest.getPlacementAreaId())
                .orElseThrow();

        // create the luggage
        LuggageEntity luggage = LuggageRequestMapper.builder()
                .withLuggageRequest(luggageRequest)
                .mapToEntity();

        // set the placement area to the luggage
        luggage.setPlacementArea(placementArea);

        // save the luggage and return the response
        return LuggageResponseMapper.builder()
                .withLuggageEntity(luggageRepository.save(luggage))
                .mapToResponse();
    }

}
