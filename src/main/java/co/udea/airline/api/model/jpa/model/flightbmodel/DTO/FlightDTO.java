package co.udea.airline.api.model.jpa.model.flightbmodel.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;


/**
 * Represents a flight data transfer object (DTO).
 * This class contains information about a flight, such as its ID, flight number, base price, tax percentage, surcharge, and scales.
 */

@Setter
@Getter
@ToString
public class FlightDTO {
    /**
     * Unique identifier of the flight.
     */
    private Long id;
    /**
     * Flight number (Generally it is two letters of the airline and 3 or 4 numbers).
     * Rule of the ICAO (International Civil Aviation Organization) and the IATA (Association
     * International Air Transport). .
     */
    private String flightNumber;
    /**
     * Base price of the flight.
     */
     private double basePrice;
    /**
     * Tax percentage of the flight for payment overruns.
     */
    private double taxPercentage;
    /**
     * Surcharge of the flight.
     */
    private double surcharge;
    /**
     * Scales of the flight.
     * This list contains information about the scales of the flight, including the airplane model,
     * origin and destination airports, departure and arrival dates for each scale.
     */
    private List<ScaleDTO> scales;

}
