package co.udea.airline.api.model.jpa.repository.bookingrepository;

import co.udea.airline.api.model.jpa.model.bookings.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookingRepository extends JpaRepository<Booking, Long> {
    static long countByFlightId(Long flightId) {
        return 0;
    }
}
