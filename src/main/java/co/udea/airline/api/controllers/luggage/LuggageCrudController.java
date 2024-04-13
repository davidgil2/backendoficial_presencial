package co.udea.airline.api.controllers.luggage;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.udea.airline.api.model.jpa.models.luggage.LuggageRequest;
import co.udea.airline.api.model.jpa.models.luggage.LuggageResponse;
import co.udea.airline.api.services.luggage.LuggageDeleteService;
import co.udea.airline.api.services.luggage.LuggageFindService;
import co.udea.airline.api.services.luggage.LuggageSaveService;
import co.udea.airline.api.services.luggage.LuggageUpdateService;
import co.udea.airline.api.utils.exceptions.RestException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/luggage")
@RequiredArgsConstructor
// This class is the controller for the luggage entity
public class LuggageCrudController {

        private final LuggageSaveService luggageSaveService;
        private final LuggageUpdateService luggageUpdateService;
        private final LuggageFindService luggageFindService;
        private final LuggageDeleteService luggageDeleteService;

        @Operation(summary = "Create a new luggage")
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "201", description = "Luggage created", content = {
                                        @Content(mediaType = "application/json", schema = @Schema(implementation = LuggageResponse.class))
                        }),
                        @ApiResponse(responseCode = "400", description = "Invalid input"),
                        @ApiResponse(responseCode = "500", description = "Internal server error", content = {
                                        @Content(mediaType = "application/json", schema = @Schema(implementation = RuntimeException.class)) })
        })
        @PostMapping
        public ResponseEntity<LuggageResponse> findAll(@RequestBody LuggageRequest luggageRequest)
                        throws RestException {
                return new ResponseEntity<>(luggageSaveService.save(luggageRequest), HttpStatus.CREATED);
        }

        @Operation(summary = "Get all luggages")
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "200", description = "Luggages found", content = {
                                        @Content(mediaType = "application/json", schema = @Schema(implementation = LuggageResponse.class)) }),
                        @ApiResponse(responseCode = "500", description = "Internal server error", content = {
                                        @Content(mediaType = "application/json", schema = @Schema(implementation = RuntimeException.class)) })
        })
        @GetMapping
        public ResponseEntity<List<LuggageResponse>> findAll() {
                return new ResponseEntity<>(luggageFindService.findAll(), HttpStatus.OK);
        }

        @Operation(summary = "Get a luggage by id")
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "200", description = "Luggage found", content = {
                                        @Content(mediaType = "application/json", schema = @Schema(implementation = LuggageResponse.class)) }),
                        @ApiResponse(responseCode = "500", description = "Internal server error", content = {
                                        @Content(mediaType = "application/json", schema = @Schema(implementation = RuntimeException.class)) })
        })
        @GetMapping("/{id}")
        public ResponseEntity<Optional<LuggageResponse>> findById(@PathVariable Long id) {
                return new ResponseEntity<>(luggageFindService.findById(id), HttpStatus.OK);
        }

        @Operation(summary = "Delete a luggage by id")
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "204", description = "Luggage deleted", content = @Content(mediaType = "application/json")),
                        @ApiResponse(responseCode = "404", description = "Luggage not found"),
                        @ApiResponse(responseCode = "500", description = "Internal server error", content = {
                                        @Content(mediaType = "application/json", schema = @Schema(implementation = RuntimeException.class)) })
        })
        @DeleteMapping("/{id}")
        public ResponseEntity<Void> delete(@PathVariable Long id) {
                luggageDeleteService.delete(id);
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        @Operation(summary = "Update a luggage by id")
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "200", description = "Luggage updated", content = {
                                        @Content(mediaType = "application/json", schema = @Schema(implementation = LuggageResponse.class)) }),
                        @ApiResponse(responseCode = "404", description = "Luggage not found"),
                        @ApiResponse(responseCode = "500", description = "Internal server error", content = {
                                        @Content(mediaType = "application/json", schema = @Schema(implementation = RuntimeException.class)) })
        })
        @PutMapping("/{id}")
        public ResponseEntity<LuggageResponse> update(@RequestBody LuggageRequest luggageRequest, @PathVariable Long id)
                        throws RestException {
                return new ResponseEntity<>(luggageUpdateService.update(luggageRequest, id), HttpStatus.OK);
        }

}
