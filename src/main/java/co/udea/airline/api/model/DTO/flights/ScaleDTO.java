package co.udea.airline.api.model.DTO.flights;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class ScaleDTO {
    @Schema(description = "The scale id auto-generated", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private Long id;

    @NotEmpty()
    private AirplaneModelDTO airplaneModel;

    @NotEmpty()
    private AirportDTO originAirport;

    @NotEmpty()
    private AirportDTO destinationAirport;

    @NotEmpty()
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Schema(example = "2024-12-30 23:59:59", pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime departureDate;

    @NotEmpty()
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Schema(example = "2024-12-31 23:59:59", pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime arrivalDate;
}