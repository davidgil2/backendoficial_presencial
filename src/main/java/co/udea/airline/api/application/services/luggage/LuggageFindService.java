package co.udea.airline.api.application.services.luggage;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import co.udea.airline.api.domain.mappers.luggage.LuggageResponseMapper;
import co.udea.airline.api.domain.models.luggage.LuggageResponse;
import co.udea.airline.api.domain.ports.luggage.ILuggageFindPort;
import co.udea.airline.api.infraestructure.repositories.LuggageRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
// This class is the service for the luggage find use case
public class LuggageFindService implements ILuggageFindPort {

    private final LuggageRepository luggageRepository;

    @Override
    public List<LuggageResponse> findAll() {

        List<LuggageResponse> luggages = luggageRepository.findAll().stream()
                .map(luggage -> LuggageResponseMapper.builder()
                        .withLuggageEntity(luggage)
                        .mapToResponse())
                .collect(Collectors.toList());

        return luggages;
    }

    @Override
    public Optional<LuggageResponse> findById(Long id) {
        return luggageRepository.findById(id).map(luggage -> LuggageResponseMapper.builder()
                .withLuggageEntity(luggage)
                .mapToResponse());
    }

}
