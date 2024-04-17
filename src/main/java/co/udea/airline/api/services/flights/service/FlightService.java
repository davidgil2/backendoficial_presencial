package co.udea.airline.api.services.flights.service;

import co.udea.airline.api.model.jpa.model.flights.Flight;
import co.udea.airline.api.model.jpa.model.flights.Scale;
import co.udea.airline.api.model.jpa.repository.flights.IFlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class FlightService {

    @Autowired
    private IFlightRepository flightRepository;

    @Autowired
    private ScaleService scaleService;

    public Flight saveFlight(Flight flight) {
        Flight flightSaved = flightRepository.save(flight);

        Set<Scale> scales = flight.getScales();
        for (Scale scale : scales) {
            scale.setFlight(flightSaved);
            scaleService.saveScale(scale);
        }

        return flightSaved;
    }

    public Flight getFlightById(Long id) {
        return flightRepository.findById(id).orElse(null);
    }
}
