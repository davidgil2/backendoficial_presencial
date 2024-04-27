package co.udea.airline.api.services.flightsservices;



import co.udea.airline.api.model.jpa.model.flightbmodel.Flight;
import co.udea.airline.api.model.jpa.model.flightbmodel.Scale;

import co.udea.airline.api.model.jpa.repository.flightbrepository.IFlightDetailsProjection;
import co.udea.airline.api.model.jpa.repository.flightbrepository.IFlightProjection;
import co.udea.airline.api.model.jpa.repository.flightbrepository.IFlightsRepository;


import co.udea.airline.api.model.jpa.repository.flightbrepository.IScaleRespository;

import org.modelmapper.ModelMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
public class FlightServices {


    @Autowired
    private IFlightsRepository flightRepository;

    @Autowired
    private ScaleServices scaleServices;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private IFlightDetailsProjection flightDetailsProjection;

    @Autowired
    private IScaleRespository scaleRepository;
    public List<Flight> searchFlights() {
        return flightRepository.findAll();
    }
    public List<IFlightProjection> searchFlightGeneral() {
        return flightRepository.findAllFlightGeneral();
    }

    public List<IFlightDetailsProjection> searchFlightDetailsByFlightNumber(String flightNumber) {
        return flightRepository.findFlightDetailsByFlightNumber(flightNumber);
    }

    public Flight addFlight(Flight flight) {
        Flight savedFlight = null;
        try {
            savedFlight = flightRepository.save(flight);;
            Set<Scale> scales = flight.getScales();
            if (scales != null && !scales.isEmpty()) {
                for (Scale scale : scales) {
                    scale.setFlight(savedFlight);
                    scaleServices.saveScale(scale);
                }
                savedFlight.setScales(scales);
            }
        } catch (Exception e) {
            System.out.println("Error al guardar el vuelo: " + e);
        }
        return savedFlight;
    }


    public void deleteFlight(Long id) {
        try {
            scaleRepository.deleteScaleByFlightId(id);
            flightRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            System.out.println("No se encontró el vuelo con id: " + id);
        } catch (Exception e) {
            System.out.println("Error al eliminar el vuelo con id: " + id + " debido a  que cuenta con almenos una reserva asociada");
        }
    }

    public List<Flight> searchFlight(Long id) {
        Flight flight = flightRepository.findById(id).orElse(null);
        return flight != null ? Collections.singletonList(flight) : Collections.<Flight>emptyList();
    }
    public Flight updateFlight(Flight flight) {
        Long flightId = flight.getId();
        if (flightId == null || !flightRepository.existsById(flightId)) {
            throw new RuntimeException("El vuelo a actualizar no existe");
        }
        return flightRepository.save(modelMapper.map(flight, Flight.class));
    }
    public Flight getFlightByFlightNumber(String flightNumber) {
        List<Flight> flights = flightRepository.findByFlightNumber(flightNumber);
        if (flights.size() == 0) {
            return null;
        } else {
            return flights.get(0);
        }
    }
    public Flight deleteFlightById(Long id) {
        Flight deletedFlight = getFlightById(id);
        if (deletedFlight == null) {
            return null;
        }
        flightRepository.deleteById(id);
        return deletedFlight;
    }
    public Flight getFlightById(Long id) {
        return flightRepository.findById(id).orElse(null);
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
