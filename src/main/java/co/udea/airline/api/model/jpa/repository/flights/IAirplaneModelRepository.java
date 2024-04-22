package co.udea.airline.api.model.jpa.repository.flights;

import co.udea.airline.api.model.jpa.model.flights.AirplaneModel;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IAirplaneModelRepository extends JpaRepository<AirplaneModel, String> {
  @Query("SELECT DISTINCT a.family FROM AirplaneModel a")
  public List<String> findAllFamilies();

  @Query("SELECT a FROM AirplaneModel a WHERE a.family = ?1")
  public List<AirplaneModel> findByFamily(String family);
}
