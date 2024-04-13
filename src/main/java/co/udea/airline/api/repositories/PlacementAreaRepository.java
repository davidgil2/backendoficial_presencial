package co.udea.airline.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.udea.airline.api.model.jpa.entities.PlacementAreaEntity;


// This interface is the repository for the placement area entity
@Repository
public interface PlacementAreaRepository extends JpaRepository<PlacementAreaEntity, Long> {

}
