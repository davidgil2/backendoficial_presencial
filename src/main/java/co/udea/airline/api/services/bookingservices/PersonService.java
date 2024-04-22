package co.udea.airline.api.services.bookingservices;

import co.udea.airline.api.model.jpa.model.bookings.Person;
import co.udea.airline.api.model.jpa.repository.bookingrepository.IPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class PersonService {
    @Autowired
    IPersonRepository personRepository;

    public List<Person> getPersons() {
        return personRepository.findAll();
    }

    public Optional<Person> getPerson(Long id) {
        return personRepository.findById(id);
    }

    public void saveOrUpdate(Person person){
        personRepository.save(person);
    }

    public void delete(Long id){
        personRepository.deleteById(id);
    }
}
