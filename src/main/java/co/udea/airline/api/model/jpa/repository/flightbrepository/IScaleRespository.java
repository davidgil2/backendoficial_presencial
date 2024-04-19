package co.udea.airline.api.model.jpa.repository.flightbrepository;

import co.udea.airline.api.model.jpa.model.flightbmodel.Scale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IScaleRespository extends JpaRepository<Scale, Long> {



}
