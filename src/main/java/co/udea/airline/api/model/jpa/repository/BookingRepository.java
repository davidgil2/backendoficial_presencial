package co.udea.airline.api.model.jpa.repository;

import co.udea.airline.api.model.jpa.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

}
