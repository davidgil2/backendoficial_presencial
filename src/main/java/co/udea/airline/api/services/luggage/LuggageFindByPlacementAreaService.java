package co.udea.airline.api.services.luggage;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import co.udea.airline.api.model.jpa.entities.PlacementAreaEntity;
import co.udea.airline.api.model.jpa.mappers.luggage.LuggageResponseMapper;
import co.udea.airline.api.model.jpa.models.luggage.LuggageResponse;
import co.udea.airline.api.model.jpa.ports.luggage.ILuggageFindByPlacementAreaPort;
import co.udea.airline.api.repositories.LuggageRepository;
import co.udea.airline.api.repositories.PlacementAreaRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class LuggageFindByPlacementAreaService implements ILuggageFindByPlacementAreaPort {

    private final LuggageRepository luggageRepository;
    private final PlacementAreaRepository placementAreaRepository;

    @Override
    public List<LuggageResponse> findByPlacementArea(Long placementAreaId) {

        // search for the placement area in the database
        PlacementAreaEntity placementArea = placementAreaRepository.findById(placementAreaId).orElseThrow();

        // search for the luggage in the database by the placement area
        return luggageRepository.findByPlacementArea(placementArea).stream()
                .map(luggage -> LuggageResponseMapper.builder()
                        .withLuggageEntity(luggage)
                        .mapToResponse())
                .collect(Collectors.toList());
    }

}
