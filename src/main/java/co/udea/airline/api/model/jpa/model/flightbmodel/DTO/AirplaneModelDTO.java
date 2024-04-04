package co.udea.airline.api.model.jpa.model.flightbmodel.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Represents an airplane model data transfer object (DTO).
 * This class contains information about an airplane model, such as its id,
 * family, number, and cargo capacity.
 */
@Setter
@Getter
@ToString
public class AirplaneModelDTO {
    /**
     * Unique identifier of the airplane model.
     */
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
