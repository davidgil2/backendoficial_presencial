package co.udea.airline.api.model.jpa.repository.flights;

import java.util.List;

import co.udea.airline.api.model.jpa.model.flights.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IFlightRepository extends JpaRepository<Flight, Long> {
  @Query("SELECT f FROM Flight f JOIN FETCH f.scales WHERE f.flightNumber = :flightNumber")
  List<Flight> findByFlightNumber(String flightNumber);
}