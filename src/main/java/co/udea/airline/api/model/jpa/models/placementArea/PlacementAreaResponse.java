package co.udea.airline.api.model.jpa.models.placementArea;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)

// This class represents the placement area response
public class PlacementAreaResponse {
    Long id;
    String name;

}
