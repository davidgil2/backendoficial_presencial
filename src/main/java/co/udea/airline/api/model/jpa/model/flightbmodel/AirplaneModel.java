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
 * Represents an airplane model.
 */
@Data
@Getter
@Setter
@RequiredArgsConstructor
@Entity


@Table(name = "AirplaneModel")

public class AirplaneModel implements Serializable {
    @Id
    @Column(name = "airplane_model", nullable = false, unique = true, updatable = true, length = 15)
    private String id;

    @NotNull
    @Column(name = "family", nullable = false, length = 15)
    private String family;

    @NotNull
    @Column(name = "capacity", nullable = false, length = 3, updatable = false)
    private double capacity;

    @NotNull
    @Column(name = "cargo_capacity", nullable = false, length = 7, updatable = false)
    private double cargoCapacity;
}
