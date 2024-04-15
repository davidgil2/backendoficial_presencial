package co.udea.airline.api.model.jpa.repository.flights;

import co.udea.airline.api.model.jpa.model.flights.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IAirportRepository extends JpaRepository<Airport, String> {
    @Query("SELECT a FROM Airport a WHERE a.id = ?1")
    public Airport findByIATA(String IATACode);
}

