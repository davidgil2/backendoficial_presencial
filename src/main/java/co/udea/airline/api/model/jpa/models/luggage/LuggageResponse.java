package co.udea.airline.api.model.jpa.models.luggage;

import lombok.Getter;
import lombok.Setter;
import co.udea.airline.api.model.jpa.models.placementArea.PlacementAreaResponse;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder

// This class represents the luggage response
public class LuggageResponse {

    Long id;
    String luggageType;
    Double extraCharge;
    Integer quantity;
    Double width;
    Double height;
    Double length;
    Double weight;
    String description;
    Long userId;
    Long flightId;
    Long bookingId;
    PlacementAreaResponse placementArea;

}
