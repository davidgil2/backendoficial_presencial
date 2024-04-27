package co.udea.airline.api.model.jpa.model.flightbmodel.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.validation.constraints.NotEmpty;

/**
 * Represents an airplane model data transfer object (DTO).
 * This class contains information about an airplane model, such as its id,
 * family, number, and cargo capacity.
 */
@Setter
@Getter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Data
@Schema(name = "AirplaneModelDTO", description = "Data Transfer Object for Airplane Model")
public class AirplaneModelDTO {
    /**
     * Unique identifier of the airplane model.
     */
    @NotEmpty
    private String id;
    /**
     * Flight to which the aircraft family belongs .
     */
    private String family;
    /**
     * Airplane license plate number.
     */
    private double number;
    /**
     * Cargo capacity of the airplane.
     */
    private double cargoCapacity;

}
