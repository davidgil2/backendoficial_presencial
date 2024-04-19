package co.udea.airline.api.controller;


import co.udea.airline.api.model.jpa.model.flightbmodel.DTO.FlightDTO;

import co.udea.airline.api.model.jpa.repository.flightbrepository.IFlightDetailsProjection;
import co.udea.airline.api.model.jpa.repository.flightbrepository.IFlightProjection;
import co.udea.airline.api.model.jpa.repository.flightbrepository.IFlightsRepository;
import co.udea.airline.api.services.flightsservices.FlightServices;
import co.udea.airline.api.model.jpa.model.flightbmodel.Flight;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/flights")
@Tag(name = "Flight Management", description = "Add, delete and update flights")
public class FlightManagementController {

    @Autowired
    private FlightServices flightService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/search")
    @Operation(summary = "Search all flights")
    @ApiResponse(responseCode = "200", content = {
            @Content(schema = @Schema(implementation = Flight.class), mediaType = MediaType.APPLICATION_JSON_VALUE)
    }, description = "List of flights")
    @ApiResponse(responseCode = "400", description = "Invalid request")
    @ApiResponse(responseCode = "500", description = "Internal error")
    public List<FlightDTO> searchFlight() {
        List<Flight> flights = flightService.searchFlights();

        List<FlightDTO> flightsDTO = flights.stream()
                .map(flight -> modelMapper.map(flight, FlightDTO.class))
                .collect(Collectors.toList());
        return flightsDTO;
    }

    @GetMapping("/searchflight")
    @Operation(summary = "Search all flights with general information")
    @ApiResponse(responseCode = "200", content = {
            @Content(schema = @Schema(implementation = Flight.class), mediaType = MediaType.APPLICATION_JSON_VALUE)
    }, description = "List of flights")
    @ApiResponse(responseCode = "400", description = "Invalid")
    @ApiResponse(responseCode = "500", description = "Internal error")
    public List<IFlightProjection> searchFlightGeneral() {
        return flightService.searchFlightGeneral();
    }

    @GetMapping("/searchdetails")
    @Operation(summary = "Search all flights with details")
    @ApiResponse(responseCode = "200", content = {
            @Content(schema = @Schema(implementation = Flight.class), mediaType = MediaType.APPLICATION_JSON_VALUE)
    }, description = "List of flights")
    @ApiResponse(responseCode = "400", description = "Invalid")
    @ApiResponse(responseCode = "500", description = "Internal error")
    public List<IFlightDetailsProjection> searchFlightDetailsByFlightNumber(@RequestParam String flightNumber) {
        return flightService.searchFlightDetailsByFlightNumber(flightNumber);
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
