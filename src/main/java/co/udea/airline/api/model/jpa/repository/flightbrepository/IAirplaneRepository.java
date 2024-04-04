package co.udea.airline.api.model.jpa.repository.flightbrepository;

import co.udea.airline.api.model.jpa.model.flightbmodel.AirplaneModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAirplaneRepository extends JpaRepository<AirplaneModel, String> {
}
