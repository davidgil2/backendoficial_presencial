package co.udea.airline.api.model.jpa.model.bookings;

import co.udea.airline.api.model.jpa.model.flightbmodel.Flight;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Data
@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "Booking", schema = "Code_factory2")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BOOKING_ID")
    private Long bookingId;

    @ManyToOne
    @JoinColumn(name = "PASSENGER_ID")
    private Passenger passenger;

    @ManyToOne
    @JoinColumn(name = "FLIGHT_ID")
    private Flight flight;

    @Column(name = "BOOKING_DATE")
    private Date booking_date;

    @Column(name = "BOOKING_STATUS")
    private String booking_status;

    @Column(name = "TOTAL_PRICE")
    private Long total_price;

}
