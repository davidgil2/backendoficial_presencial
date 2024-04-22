package co.udea.airline.api.services.flights.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.udea.airline.api.model.jpa.model.flights.Airport;
import co.udea.airline.api.model.jpa.repository.flights.IAirportRepository;

@Service
public class AirportService {
  @Autowired
  private IAirportRepository airportRepository;

  public List<Airport> getAllAirports() {
    return airportRepository.findAll();
  }

  public Airport getAirportById(String id) {
    return airportRepository.findById(id).orElse(null);
  }

  public Airport getAirportByIATACode(String IATACode) {
    return airportRepository.findByIATA(IATACode);
  }

  public List<Airport> getAirportsByCity(String city) {
    return airportRepository.findByCity(city);
  }

  public List<Airport> getAirportsByCountry(String country) {
    return airportRepository.findByCountry(country);
  }

  public List<String> getAllCities() {
    return airportRepository.findAllCities();
  }

  public List<String> getAllCountries() {
    return airportRepository.findAllCountries();
  }

  public List<String> getCitiesByCountry(String country) {
    return airportRepository.findCitiesByCountry(country);
  }
}
