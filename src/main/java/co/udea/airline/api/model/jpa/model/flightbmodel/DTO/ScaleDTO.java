package co.udea.airline.api.model.jpa.model.flightbmodel.DTO;

import co.udea.airline.api.model.jpa.model.flightbmodel.AirplaneModel;
import co.udea.airline.api.model.jpa.model.flightbmodel.Airport;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;


@Setter
@Getter
@ToString
/**
 * Represents a scale data transfer object (DTO).
 * This class contains information about a scale, including the airplane model, origin and destination airports, departure and arrival dates.
 */
public class ScaleDTO {
    /**
     * Unique identifier of the scale.
     */
    private Long scaleId;
    /**
     * Airplane model used for the scale.
     */
    private AirplaneModel airplaneModel;
    /**
     * Origin airport of the scale.
     */
    private Airport originAirport;
    /**
     * Destination airport of the scale.
     */
    private Airport destinationAirport;
    /**
     * Departure date of the scale.
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime departureDate;
    /**
     * Arrival date of the scale.
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime arrivalDate;
}
