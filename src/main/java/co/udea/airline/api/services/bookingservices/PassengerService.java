package co.udea.airline.api.services.bookingservices;

import co.udea.airline.api.model.jpa.model.bookings.Passenger;
import co.udea.airline.api.model.jpa.repository.bookingrepository.IPassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PassengerService {
    @Autowired
    IPassengerRepository passengerRepository;

    public List<Passenger> getPassengers() {
        return passengerRepository.findAll();
    }

    public Optional<Passenger> getPassenger(Long id) {
        return passengerRepository.findById(id);
    }

    public void saveOrUpdate(Passenger passenger){
        passengerRepository.save(passenger);
    }

    public void delete(Long id){
        passengerRepository.deleteById(id);
    }
}
