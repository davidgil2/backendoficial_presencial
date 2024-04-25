package co.udea.airline.api.model.jpa.dto.user;

import lombok.*;
import java.sql.Timestamp;

/**
 * Data Transfer Object (DTO) representing boarding pass information.
 * This DTO is used for transferring boarding pass information between layers of the application.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoardingPassDTO {
    /**
     * Unique identifier for the boarding pass.
     */
    private Long boardingPassId;

    /**
     * Identifier of the passenger associated with this boarding pass.
     */
    private Long passengerId;

    /**
     * Identifier of the booking associated with this boarding pass.
     */
    private Long bookingId;

    /**
     * Identifier of the flight associated with this boarding pass.
     */
    private Long flightId;

    /**
     * Identifier of the medical information associated with this boarding pass.
     */
    private Long medicalInfoId;

    /**
     * Identifier of the luggage information associated with this boarding pass.
     */
    private Long luggageInfoId;

    /**
     * Timestamp indicating the boarding time.
     */
    private Timestamp boardingTime;
}
