package co.udea.airline.api.services.luggage;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import co.udea.airline.api.model.jpa.mappers.luggage.LuggageResponseMapper;
import co.udea.airline.api.model.jpa.models.luggage.LuggageResponse;
import co.udea.airline.api.model.jpa.ports.luggage.ILuggageFindPort;
import co.udea.airline.api.repositories.LuggageRepository;
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
