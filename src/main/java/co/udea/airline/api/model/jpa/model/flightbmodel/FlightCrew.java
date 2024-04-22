package co.udea.airline.api.model.jpa.model.flightbmodel;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/**
 * Represents a flight crew member in the airline system.
 */
@Data
@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "FlightCrew")
public class FlightCrew {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "flight_crew_id", updatable = false, nullable = false)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "flight_id")
    private Flight flight;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @NotNull
    @Column(name = "flight_role", nullable = false, length = 30)
    private String flightRole;
}
