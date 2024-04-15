package co.udea.airline.api.model.jpa.model.flights;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "FLIGHT")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "flight_id")
    private long id;

    @Column(name = "flight_number", unique = true)
    private String flightNumber;

    @Column(name = "base_price", nullable = false, precision = 22, scale = 0)
    private double basePrice;

    @Column(name = "tax_percent")
    private double taxPercent;

    @Column(name = "surcharge")
    private double surcharge;

    @OneToMany(mappedBy = "flight")
    private Set<Scale> scales;
}
