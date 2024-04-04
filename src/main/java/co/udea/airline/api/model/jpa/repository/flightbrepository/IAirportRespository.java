package co.udea.airline.api.model.jpa.repository.flightbrepository;

import co.udea.airline.api.model.jpa.model.flightbmodel.Airport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAirportRespository extends JpaRepository<Airport, String> {

}
