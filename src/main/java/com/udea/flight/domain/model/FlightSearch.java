package com.udea.flight.domain.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Search_Flights")
public class FlightSearch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_flight")
    private Long flightId;

    @Column(name ="departure_date")
    private LocalDate departureDate;

    @Column(name ="arrival_date")
    private LocalDate arrivalDate;

    @Column(name = "origin_city")
    private String originCity;

    @Column(name = "destination_city")
    private String destinationCity;

    @Column(name = "price")
    private Double price;
}
