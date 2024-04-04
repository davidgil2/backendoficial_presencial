package co.udea.airline.api.model.jpa.model.flightbmodel.DTO;

import co.udea.airline.api.model.jpa.model.flightbmodel.Employee;
import co.udea.airline.api.model.jpa.model.flightbmodel.Flight;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Represents a flight crew data transfer object.
 * Contains information about the flight crew member, such as their ID,
 * associated flight, employee details, and flight role.
 */
@Setter
@Getter
@ToString
public class FlightCrewDTO {
    /**
     * Unique identifier of the flight crew member.
     */
    private Long id;
    /**
     * Flight to which the crew member is associated.
     */
    private Flight flight;
    /**
     * Employee details of the crew member.
     */
    private Employee employee;
    /**
     * Role of the crew member in the flight.
     */
    private String flightRole;

}
