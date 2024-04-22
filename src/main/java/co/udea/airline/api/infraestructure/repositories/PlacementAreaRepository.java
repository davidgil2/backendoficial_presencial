package co.udea.airline.api.infraestructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.udea.airline.api.domain.entities.PlacementAreaEntity;

// This interface is the repository for the placement area entity
@Repository
public interface PlacementAreaRepository extends JpaRepository<PlacementAreaEntity, Long> {

}
