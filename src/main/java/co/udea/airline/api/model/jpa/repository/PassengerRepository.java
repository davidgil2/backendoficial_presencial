package co.udea.airline.api.model.jpa.repository;

import co.udea.airline.api.model.jpa.model.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger, Long> {
    List<Passenger> findBybookingId(Long bookingId);
    List<Passenger> findBypersonId(Long personId);
}
