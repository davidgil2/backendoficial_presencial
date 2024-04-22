package co.udea.airline.api.domain.models.luggage;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)

// This class represents the luggage request
public class LuggageRequest {

    @JsonProperty("luggage_type")
    String luggageType;
    @JsonProperty("extra_charge")
    Double extraCharge;
    Integer quantity;
    Double width;
    Double height;
    Double length;
    Double weight;
    String description;

    @JsonProperty("user_id")
    Long userId;

    @JsonProperty("flight_id")
    Long flightId;

    @JsonProperty("booking_id")
    Long bookingId;

    @JsonProperty("placement_area_id")
    Long placementAreaId;
    
}
