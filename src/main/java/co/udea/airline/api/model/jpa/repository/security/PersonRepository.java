package co.udea.airline.api.model.jpa.repository.security;

import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

import co.udea.airline.api.model.jpa.model.security.Person;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    Optional<User> findByUsername(String username);
    
}
