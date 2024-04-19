package co.udea.airline.api.model.jpa.repository.flightbrepository;

import co.udea.airline.api.model.jpa.model.flightbmodel.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IFlightsRepository extends JpaRepository<Flight, Long> {

    @Query(value = "SELECT " +
            "f.flight_number AS flightNumber, " +
            "f.flight_type AS flightType, " +
            "a.city AS originCity, " +
            "ar.city AS destinationCity, " +
            "s.departure_date AS departureDate, " +
            "s.arrival_date AS arrivalDate " +
            "FROM flight f " +
            "JOIN scale s ON f.flight_id = s.flight_id " +
            "JOIN airport a ON a.airport_code = s.origin_airport " +
            "JOIN airport ar ON ar.airport_code = s.destination_airport",
            nativeQuery = true)
    List<IFlightProjection> findAllFlightGeneral();

    @Query(value = "SELECT f.flight_number AS flightNumber, " +
            "f.flight_type AS flightType, " +
            "a.city AS originCity, " +
            "ar.city AS destinationCity, " +
            "s.departure_date AS departureDate, " +
            "s.arrival_date AS arrivalDate, " +
            "f.base_price AS basePrice, " +
            "f.tax_percent AS taxPercent, " +
            "f.surcharge AS surcharge, " +
            "am.airplane_model AS airplaneModel, " +
            "am.capacity AS capacity " +
            "FROM flight f " +
            "JOIN scale s ON f.flight_id = s.flight_id " +
            "JOIN airport a ON a.airport_code = s.origin_airport " +
            "JOIN airport ar ON ar.airport_code = s.destination_airport " +
            "JOIN airplane_model am ON s.airplane_model = am.airplane_model " +
            "WHERE f.flight_number = :flightNumber", nativeQuery = true)
    List<IFlightDetailsProjection> findFlightDetailsByFlightNumber(String flightNumber);

}
