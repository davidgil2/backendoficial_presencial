package co.udea.airline.api.model.jpa.repository.bookingrepository;


import co.udea.airline.api.model.jpa.model.bookings.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPersonRepository extends JpaRepository<Person, Long> {
}
