package co.udea.airline.api.application.services.placementArea;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import co.udea.airline.api.domain.mappers.placementarea.PlacementAreaResponseMapper;
import co.udea.airline.api.domain.models.placementArea.PlacementAreaResponse;
import co.udea.airline.api.domain.ports.placementarea.IPlacementAreaFindPort;
import co.udea.airline.api.infraestructure.repositories.PlacementAreaRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class PlacementAreaFindService implements IPlacementAreaFindPort {

    private final PlacementAreaRepository placementAreaRepository;

    @Override
    public List<PlacementAreaResponse> findAll() {

        return placementAreaRepository.findAll().stream()
                .map(placementArea -> PlacementAreaResponseMapper.builder()
                        .withPlacementAreaEntity(placementArea)
                        .mapToResponse())
                .collect(Collectors.toList());
    }

    @Override
    public Optional<PlacementAreaResponse> findById(Long id) {
        
        return placementAreaRepository.findById(id).map(placementArea -> PlacementAreaResponseMapper.builder()
                .withPlacementAreaEntity(placementArea)
                .mapToResponse());
    }

}
