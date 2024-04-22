package co.udea.airline.api.domain.mappers.luggage;

import co.udea.airline.api.domain.entities.LuggageEntity;
import co.udea.airline.api.domain.mappers.placementarea.PlacementAreaResponseMapper;
import co.udea.airline.api.domain.models.luggage.LuggageResponse;

// This class maps the luggage entity to the luggage response
public class LuggageResponseMapper {

    private LuggageEntity luggageEntity;

    private LuggageResponseMapper() {

    }

    public static LuggageResponseMapper builder() {
        return new LuggageResponseMapper();
    }

    public LuggageResponseMapper withLuggageEntity(LuggageEntity luggageEntity) {
        this.luggageEntity = luggageEntity;
        return this;
    }

    public LuggageResponse mapToResponse() {
        return LuggageResponse.builder()
                .id(luggageEntity.getId())
                .luggageType(luggageEntity.getLuggageType())
                .extraCharge(luggageEntity.getExtraCharge())
                .quantity(luggageEntity.getQuantity())
                .width(luggageEntity.getWidth())
                .height(luggageEntity.getHeight())
                .length(luggageEntity.getLength())
                .weight(luggageEntity.getWeight())
                .description(luggageEntity.getDescription())
                .userId(luggageEntity.getUserId())
                .flightId(luggageEntity.getFlightId())
                .bookingId(luggageEntity.getBookingId())
                .placementArea(PlacementAreaResponseMapper.builder()
                        .withPlacementAreaEntity(luggageEntity.getPlacementArea())
                        .mapToResponse())
                .build();
    }

}
