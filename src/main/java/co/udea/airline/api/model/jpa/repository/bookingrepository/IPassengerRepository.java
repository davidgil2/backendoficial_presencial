package co.udea.airline.api.model.jpa.repository.bookingrepository;


import co.udea.airline.api.model.jpa.model.bookings.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPassengerRepository extends JpaRepository<Passenger, Long> {
}
