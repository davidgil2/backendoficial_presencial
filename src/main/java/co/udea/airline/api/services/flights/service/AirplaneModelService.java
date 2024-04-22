package co.udea.airline.api.services.flights.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.udea.airline.api.model.jpa.model.flights.AirplaneModel;
import co.udea.airline.api.model.jpa.repository.flights.IAirplaneModelRepository;

@Service
public class AirplaneModelService {
  @Autowired
  private IAirplaneModelRepository airplaneModelRepository;

  public List<AirplaneModel> getAllAirplaneModels() {
    return airplaneModelRepository.findAll();
  }

  public AirplaneModel getAirplaneModelById(String id) {
    return airplaneModelRepository.findById(id).orElse(null);
  }

  public List<String> getAirplaneModelFamilies() {
    return airplaneModelRepository.findAllFamilies();
  }

  public List<AirplaneModel> getAirplaneModelsByFamily(String familyId) {
    return airplaneModelRepository.findByFamily(familyId);
  }
}
