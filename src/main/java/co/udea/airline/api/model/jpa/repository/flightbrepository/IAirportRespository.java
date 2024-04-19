package co.udea.airline.api.model.jpa.repository.flightbrepository;

import co.udea.airline.api.model.jpa.model.flightbmodel.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAirportRespository extends JpaRepository<Airport, String> {

}
