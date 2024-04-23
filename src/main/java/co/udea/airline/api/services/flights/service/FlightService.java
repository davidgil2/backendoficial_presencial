package co.udea.airline.api.services.flights.service;

import co.udea.airline.api.model.jpa.model.flights.Flight;
import co.udea.airline.api.model.jpa.model.flights.Scale;
import co.udea.airline.api.model.jpa.repository.flights.IFlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class FlightService {

    @Autowired
    private IFlightRepository flightRepository;

    @Autowired
    private ScaleService scaleService;

    public Flight saveFlight(Flight flight) {

        flight.generateFlightNumber();

        Flight flightSaved = flightRepository.save(flight);

        Set<Scale> scales = flight.getScales();
        for (Scale scale : scales) {
            scale.setFlight(flightSaved);
            scaleService.saveScale(scale);
        }
        
        flight.generateFlightType();
        flightSaved = flightRepository.save(flight);

        return flightSaved;
    }

    public Flight getFlightById(Long id) {
        return flightRepository.findById(id).orElse(null);
    }

    public Flight getFlightByFlightNumber(String flightNumber) {
        List<Flight> flights = flightRepository.findByFlightNumber(flightNumber);
        if (flights.size() == 0) {
            return null;
        } else {
            return flights.get(0);
        }
    }

    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    public Flight deleteFlightById(Long id) {
        Flight deletedFlight = getFlightById(id);

        // TODO: Add booking service to validate if the flight has bookings

        if (deletedFlight == null) {
            return null;
        }

        flightRepository.deleteById(id);
        return deletedFlight;
    }

    public Flight deleteFlightByFlightNumber(String flightNumber) {
        Flight deletedFlight = getFlightByFlightNumber(flightNumber);

        if (deletedFlight == null) {
            return null;
        }

        deleteFlightById(deletedFlight.getId());

        return deletedFlight;
    }
}
