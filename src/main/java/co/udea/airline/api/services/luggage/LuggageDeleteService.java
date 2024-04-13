package co.udea.airline.api.services.luggage;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import co.udea.airline.api.model.jpa.ports.luggage.ILuggageDeletePort;
import co.udea.airline.api.repositories.LuggageRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
// This class is the service for the luggage delete use case
public class LuggageDeleteService implements ILuggageDeletePort {

    private final LuggageRepository luggageRepository;

    @Override
    public void delete(Long id) {

        if (!luggageRepository.existsById(id)) {
            throw new NoSuchElementException("Luggage not found");
        }
        luggageRepository.deleteById(id);
    }

}
