package co.udea.airline.api.model.jpa.model.bookings.DTO;

import co.udea.airline.api.model.jpa.model.bookings.Passenger;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Setter
@Getter
@ToString
public class BookingDTO {
    private Long bookingId;
    private Passenger passenger;
    private Date booking_date;
    private String booking_status;
    private Long total_price;
}
