package co.udea.airline.api.controller;

import co.udea.airline.api.model.jpa.model.flights.Flight;
import co.udea.airline.api.services.flights.service.FlightService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;

import co.udea.airline.api.model.DTO.flights.FlightDTO;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@RequestMapping("/api/flights")
@CrossOrigin(origins = "*")
@Tag(name = "Flight Management", description = "CRUD operations for flights")
public class FlightController {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private FlightService flightService;

    @PostMapping("")
    @Operation(summary = "Create a new flight", description = "Create a new flight")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Flight created")
    })
    public ResponseEntity<FlightDTO> createFlight(@Valid @RequestBody FlightDTO flight) {
        // TODO: Add body validation
        // TODO: Add standard response
        Flight flightRes = modelMapper.map(flight, Flight.class);
        flightRes = flightService.saveFlight(flightRes);
        FlightDTO flightResDTO = modelMapper.map(flightRes, FlightDTO.class);

        return new ResponseEntity<FlightDTO>(flightResDTO, HttpStatus.CREATED);
    }

    @Operation(summary = "Get all flights", description = "Get all flights")
    @GetMapping("")
    public ResponseEntity<FlightDTO[]> getMethodName() {
        // TODO: process GET request

        return ResponseEntity.ok(new FlightDTO[0]);
    }

    @Operation(summary = "Returns only one flight by id", description = "Returns only one flight by id")
    @GetMapping("/{id}")
    public ResponseEntity<FlightDTO> getMethodNameById(@PathVariable String id) {
        // TODO: process GET request

        return ResponseEntity.ok(new FlightDTO());
    }

    @Operation(summary = "Update flight by id", description = "Update flight by id")
    @PatchMapping("/{id}")
    public ResponseEntity<FlightDTO> putMethodName(@PathVariable String id, @RequestBody FlightDTO flight) {
        // TODO: process PUT request

        return ResponseEntity.ok(new FlightDTO());
    }

    @Operation(summary = "Delete flight by id", description = "Delete flight by id")
    @DeleteMapping("/{id}")
    public ResponseEntity<FlightDTO> deleteMethodName(@PathVariable String id) {
        // TODO: process DELETE request

        return ResponseEntity.ok(new FlightDTO());
    }

}
