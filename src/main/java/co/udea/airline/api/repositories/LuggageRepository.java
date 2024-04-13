package co.udea.airline.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.udea.airline.api.model.jpa.entities.LuggageEntity;
import co.udea.airline.api.model.jpa.entities.PlacementAreaEntity;

import java.util.List;


// This interface is the repository for the luggage entity
@Repository
public interface LuggageRepository extends JpaRepository<LuggageEntity, Long>{

    List<LuggageEntity> findByPlacementArea(PlacementAreaEntity placementArea);
    
}
