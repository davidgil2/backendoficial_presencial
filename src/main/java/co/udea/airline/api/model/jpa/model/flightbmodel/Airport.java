package co.udea.airline.api.model.jpa.model.flightbmodel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
/**
 * Represents an airport.
 */
@Data
@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "Airport")
public class Airport implements Serializable {

    @Id
    @Column(name = "airport_code", nullable = false, unique = true, updatable = true, length = 3)
    private String id;

    @NotNull
    @Column(name = "name", nullable = false, length = 80)
    private String name;
    @NotNull
    @Column(name = "type", nullable = false, length = 20)
    private String type;

    @NotNull
    @Column(name = "city", nullable = false, length = 80)
    private String city;

    @NotNull
    @Column(name = "country", nullable = false, length = 30)
    private String country;

    @NotNull
    @Column(name = "runways", nullable = false, length = 2, updatable = false)
    private double runways;
}
