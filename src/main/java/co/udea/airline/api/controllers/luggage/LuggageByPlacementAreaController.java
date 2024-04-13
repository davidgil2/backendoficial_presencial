package co.udea.airline.api.controllers.luggage;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.udea.airline.api.model.jpa.models.luggage.LuggageResponse;
import co.udea.airline.api.services.luggage.LuggageFindByPlacementAreaService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/luggage/placement-area")
@RequiredArgsConstructor
public class LuggageByPlacementAreaController {

    private final LuggageFindByPlacementAreaService luggageFindByPlacementAreaService;

    @Operation(summary = "Get all luggages by a specific placement area")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Luggages found", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = LuggageResponse.class))
            }),
            @ApiResponse(responseCode = "404", description = "Luggages not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = RuntimeException.class)) })
    })
    @GetMapping("/{id}")
    public ResponseEntity<List<LuggageResponse>> findByPlacementArea(@PathVariable Long id) {
        return new ResponseEntity<>(luggageFindByPlacementAreaService.findByPlacementArea(id), HttpStatus.OK);
    }

}
