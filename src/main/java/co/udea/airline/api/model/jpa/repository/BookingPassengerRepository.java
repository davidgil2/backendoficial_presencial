package co.udea.airline.api.model.jpa.repository;

import co.udea.airline.api.model.jpa.model.Booking_Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingPassengerRepository extends JpaRepository<Booking_Passenger, Long> {
}
