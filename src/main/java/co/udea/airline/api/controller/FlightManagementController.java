package co.udea.airline.api.controller;


import co.udea.airline.api.model.jpa.model.flightbmodel.DTO.FlightDTO;

import co.udea.airline.api.services.flightsservices.FlightServices;
import co.udea.airline.api.model.jpa.model.flightbmodel.Flight;


import io.swagger.v3.oas.annotations.tags.Tag;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flights")
@Tag(name = "Flight Management", description = "Add, delete and update flights")
public class FlightManagementController {

    @Autowired
    private FlightServices flightService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/search")
    public List<Flight> searchFlights() {
        return flightService.searchFlights();
    }

    /**
     * Add a new flight
     *
     * @param flight FlightDTO object with the flight information
     * @return FlightDTO object with the saved flight information
     */
    @PostMapping("/add")
    public FlightDTO addFlight(@RequestBody FlightDTO flight) {
        Flight transformedFlight = modelMapper.map(flight, Flight.class);
        Flight savedFlight = flightService.addFlight(transformedFlight);
        return modelMapper.map(savedFlight, FlightDTO.class);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteFlight(@PathVariable Long id) {
        flightService.deleteFlight(id);
    }

    @GetMapping("/search/{id}")
    public List<Flight> searchFlight(@PathVariable Long id) {
        return flightService.searchFlight(id);
    }

    @PutMapping("/update")
    public Flight updateFlight(@RequestBody Flight flight) {
        return flightService.updateFlight(flight);
    }
}
