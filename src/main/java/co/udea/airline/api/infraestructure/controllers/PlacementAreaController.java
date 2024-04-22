package co.udea.airline.api.infraestructure.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.udea.airline.api.application.services.placementArea.PlacementAreaFindService;
import co.udea.airline.api.domain.models.placementArea.PlacementAreaResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/placement-area")
// This class is the controller for the placement area entity
public class PlacementAreaController {

    private final PlacementAreaFindService placementAreaFindService;

    @Operation(summary = "Get all placement areas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Placement areas found", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = PlacementAreaResponse.class)) }),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = RuntimeException.class)) })
    })
    @GetMapping
    public ResponseEntity<List<PlacementAreaResponse>> findAll() {
        return new ResponseEntity<>(placementAreaFindService.findAll(),
                HttpStatus.OK);
    }

    @Operation(summary = "Get a placement area by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Placement area found", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = PlacementAreaResponse.class)) }),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = RuntimeException.class)) })
    })
    @GetMapping("/{id}")
    public ResponseEntity<Optional<PlacementAreaResponse>> findById(@PathVariable Long id) {
        return new ResponseEntity<>(placementAreaFindService.findById(id),
                HttpStatus.OK);
    }

}
