package com.udea.vuelo.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.udea.vuelo.model.Flight;
import com.udea.vuelo.model.Price;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


@Service
public class FlightService {
    //Ruta del archivo
    private final String filePath = "flights.json";

    //Método de la lógica de búsqueda de vuelos
    public List<List<Flight>> searchFlightsByDate(LocalDate startDate, LocalDate endDate) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream(filePath);

            if(inputStream != null) {
                Flight[] flights = objectMapper.readValue(inputStream, Flight[].class);
                return Arrays.asList(
                        Arrays.stream(flights)
                                .filter(flight -> isDateInRange(flight.getDepartureDate(), startDate, endDate))
                                .collect(Collectors.toList()));
            } else {
                return null;
            }
        } catch (IOException e) {
            throw new RuntimeException("Error leyendo el archivo JSON ", e);
        }
    }

    private boolean isDateInRange(LocalDate dateToCheck, LocalDate startDate, LocalDate endDate) {
        // Verifica si la fecha está en el rango correcto
        return !dateToCheck.isBefore(startDate) && !dateToCheck.isAfter(endDate);
    }

    public List<List<Flight>> searchFlightsByTotalCost(int startCost, int endCost) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream(filePath);

            if(inputStream != null) {
                Flight[] flights = objectMapper.readValue(inputStream, Flight[].class);
                return Arrays.stream(flights)
                        .filter(flight -> isCostInRange(flight.getPrice().getTotalCost(), startCost, endCost))
                        .collect(Collectors.groupingBy(Flight::getAirline))
                        .values()
                        .stream()
                        .map(flightList -> flightList.stream().sorted(Comparator.comparingInt(flight -> flight.getPrice().getTotalCost())).collect(Collectors.toList()))
                        .collect(Collectors.toList());
            } else {
                return null;
            }
        } catch (IOException e) {
            throw new RuntimeException("Error leyendo el archivo JSON ", e);
        }
    }

    private boolean isCostInRange(int cost, int start, int end) {
        return cost >= start && cost <= end;
    }

    public List<List<Flight>> searchFlightsByRoute(String origin, String destination) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream(filePath);

            if(inputStream != null) {
                Flight[] flights = objectMapper.readValue(inputStream, Flight[].class);
                return Arrays.asList(
                        Arrays.stream(flights)
                                .filter(flight -> isRouteInRoutes(flight.getOrigin(),flight.getDestination(),origin, destination))
                                .collect(Collectors.toList()));
            } else {
                return null;
            }
        } catch (IOException e) {
            throw new RuntimeException("Error leyendo el archivo JSON ", e);
        }
    }

    private boolean isRouteInRoutes(String origintocheck,String destinationtocheck, String origin, String destination) {
        // Verifica si el precio está en el rango correcto
        return Objects.equals(origintocheck, origin) && Objects.equals(destinationtocheck, destination);
    }

    public List<List<Flight>> searchFlightsByAirline(String airline) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream(filePath);

            if(inputStream != null) {
                Flight[] flights = objectMapper.readValue(inputStream, Flight[].class);
                return Arrays.asList(
                        Arrays.stream(flights)
                                .filter(flight -> isAirlineInFlights(flight.getAirline(),airline))
                                .collect(Collectors.toList()));
            } else {
                return null;
            }
        } catch (IOException e) {
            throw new RuntimeException("Error leyendo el archivo JSON ", e);
        }
    }

    private boolean isAirlineInFlights(String airlinetocheck, String airline ) {
        // Verifica si el precio está en el rango correcto
        return Objects.equals(airlinetocheck, airline);
    }

    public Price searchPriceById(int id) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream(filePath);

            if (inputStream != null) {
                Flight[] flights = objectMapper.readValue(inputStream, Flight[].class);
                for (Flight flight : flights) {
                    if (flight.getId() == id) {
                        return flight.getPrice(); // Devuelve directamente el objeto Price
                    }
                }
            }
            return null; // Indica que no se encontró el vuelo con el ID dado
        } catch (IOException e) {
            throw new RuntimeException("Error leyendo el archivo JSON ", e);
        }
    }






}
