package co.udea.airline.api.services.luggage;

import org.springframework.stereotype.Service;

import co.udea.airline.api.model.jpa.entities.LuggageEntity;
import co.udea.airline.api.model.jpa.entities.PlacementAreaEntity;
import co.udea.airline.api.model.jpa.mappers.luggage.LuggageResponseMapper;
import co.udea.airline.api.model.jpa.models.luggage.LuggageRequest;
import co.udea.airline.api.model.jpa.models.luggage.LuggageResponse;
import co.udea.airline.api.model.jpa.ports.luggage.ILuggageUpdatePort;
import co.udea.airline.api.repositories.LuggageRepository;
import co.udea.airline.api.repositories.PlacementAreaRepository;
import co.udea.airline.api.utils.exceptions.NumberNotValidException;
import co.udea.airline.api.utils.exceptions.RestException;
import co.udea.airline.api.utils.handler.luggage.validation.LuggageValidation;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
// This class is the service for the luggage update use case
public class LuggageUpdateService implements ILuggageUpdatePort {

    private final LuggageRepository luggageRepository;
    private final PlacementAreaRepository placementAreaRepository;

    @Override
    public LuggageResponse update(LuggageRequest luggageRequest, Long id) throws RestException {

        // validate if the luggage exists
        LuggageEntity luggage = luggageRepository.findById(id).orElseThrow();

        // validate the fields of the luggage request
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

        // update the luggage
        luggage.setLuggageType(luggageRequest.getLuggageType());
        if (luggageRequest.getExtraCharge() != null) {
            luggage.setExtraCharge(luggageRequest.getExtraCharge());
        }
        if (luggageRequest.getQuantity() != null) {
            luggage.setQuantity(luggageRequest.getQuantity());
        }
        luggage.setQuantity(luggageRequest.getQuantity());
        luggage.setWidth(luggageRequest.getWidth());
        luggage.setHeight(luggageRequest.getHeight());
        luggage.setLength(luggageRequest.getLength());
        luggage.setWeight(luggageRequest.getWeight());
        luggage.setDescription(luggageRequest.getDescription());
        luggage.setPlacementArea(placementArea);
        luggage.setUserId(luggageRequest.getUserId());
        luggage.setFlightId(luggageRequest.getFlightId());
        luggage.setBookingId(luggageRequest.getBookingId());

        // save the luggage and return the response
        return LuggageResponseMapper.builder()
                .withLuggageEntity(luggageRepository.save(luggage))
                .mapToResponse();
    }

}
