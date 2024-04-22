package co.udea.airline.api.model.jpa.model.flightbmodel;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


import java.time.LocalDateTime;

/**
 * Represents a scale in an airline system.
 * A scale is a stopover between the origin and destination airports during a flight.
 */

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "Scale")
public class Scale {
      @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "scale_id", updatable = false, nullable = false)
        private Long id;

        @ManyToOne( cascade = CascadeType.ALL)
        @JoinColumn(name = "flight_id")
        private Flight flight;

        @ManyToOne(cascade = CascadeType.ALL)
        @JoinColumn(name = "airplane_model")
        private AirplaneModel airplaneModel;

        @ManyToOne(cascade = CascadeType.ALL)
        @JoinColumn(name = "origin_airport")
        private Airport originAirport;

        @ManyToOne(cascade = CascadeType.ALL)
        @JoinColumn(name = "destination_airport")
        private Airport destinationAirport;

        @JsonDeserialize(using = LocalDateTimeDeserializer.class)
        @Column(name = "departure_date", nullable = false)
        private LocalDateTime departureDate;

        @JsonDeserialize(using = LocalDateTimeDeserializer.class)
        @Column(name = "arrival_date", nullable = false)
        private LocalDateTime arrivalDate;
}
