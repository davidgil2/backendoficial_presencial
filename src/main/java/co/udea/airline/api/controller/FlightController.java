package co.udea.airline.api.controller;


import co.udea.airline.api.model.jpa.model.Flight;
import co.udea.airline.api.service.FlightService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/flight")
@Tag(name = "Flights")
public class FlightController {
    @Autowired
    private FlightService flightService;

    @GetMapping("/flights")
    public List<Flight> getFlights() {
        return flightService.getFlights();
    }

    @GetMapping("/{flightId}")
    public Optional<Flight> getFlightById(@PathVariable Long flightId) {
        return flightService.getFlight(flightId);
    }

    @PostMapping("/flight")
    public void saveFlight(@RequestBody Flight flight) {
        flightService.saveOrUpdate(flight);
    }

    @DeleteMapping("/{flightId}")
    public void deleteFlight(@PathVariable Long flightId){
        flightService.delete(flightId);
    }
}
