package co.udea.airline.api.model.jpa.repository.flights;

import co.udea.airline.api.model.jpa.model.flights.Airport;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IAirportRepository extends JpaRepository<Airport, String> {
    @Query("SELECT a FROM Airport a WHERE a.id = ?1")
    public Airport findByIATA(String IATACode);

    @Query("SELECT a FROM Airport a WHERE a.city = ?1")
    public List<Airport> findByCity(String city);

    @Query("SELECT a FROM Airport a WHERE a.country = ?1")
    public List<Airport> findByCountry(String country);

    @Query("SELECT DISTINCT a.city FROM Airport a")
    public List<String> findAllCities();

    @Query("SELECT DISTINCT a.country FROM Airport a")
    public List<String> findAllCountries();

    @Query("SELECT DISTINCT a.city FROM Airport a WHERE a.country = ?1")
    public List<String> findCitiesByCountry(String country);
}
