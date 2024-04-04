package co.udea.airline.api.model.jpa.model.flightbmodel.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Represents an airport data transfer object (DTO).
 * This class contains information about an airport.
 */
@Setter
@Getter
@ToString
public class AirportDTO {
    /**
     * Unique identifier of the airport (CODE IATA).
     */
    private String id;
    /**
     * Name of the airport.
     */
    private String name;
    /**
     * Type of airport national or international.
     */
    private String type;
    /**
     * City where the airport is located.
     */
    private String city;
    /**
     * Country where the airport is located.
     */
    private String country;
    /**
     * Number of runways at the airport.
     */
    private double runways;
}
