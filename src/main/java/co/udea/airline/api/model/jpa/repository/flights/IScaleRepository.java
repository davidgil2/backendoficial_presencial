package co.udea.airline.api.model.jpa.repository.flights;

import co.udea.airline.api.model.jpa.model.flights.Scale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IScaleRepository extends JpaRepository<Scale, Long> {
}
