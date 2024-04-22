package co.udea.airline.api.model.jpa.repository.flightbrepository;

import co.udea.airline.api.model.jpa.model.flightbmodel.Scale;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IScaleRespository extends JpaRepository<Scale, Long> {

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM scale WHERE flight_id = :flightId", nativeQuery = true)
    void deleteScaleByFlightId(Long flightId);

}
