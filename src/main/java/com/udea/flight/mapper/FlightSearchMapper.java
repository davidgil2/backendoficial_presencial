package com.udea.flight.mapper;

import com.udea.flight.domain.dto.FlightSearchDTO;
import com.udea.flight.domain.model.FlightSearch;

public class FlightSearchMapper {
    public static FlightSearchDTO mapToFlightSearchDTO(FlightSearch flightSearch) {
        return new FlightSearchDTO(
                flightSearch.getFlightId(),
                flightSearch.getArrivalDate(),
                flightSearch.getDepartureDate(),
                flightSearch.getOriginCity(),
                flightSearch.getDestinationCity(),
                flightSearch.getPrice()
        );
    }

    public static FlightSearch mapToFlightSearch(FlightSearchDTO flightSearchDto) {
        return new FlightSearch(
                flightSearchDto.getFlightId(),
                flightSearchDto.getArrivalDate(),
                flightSearchDto.getDepartureDate(),
                flightSearchDto.getOriginCity(),
                flightSearchDto.getDestinationCity(),
                flightSearchDto.getPrice()
        );
    }
}
