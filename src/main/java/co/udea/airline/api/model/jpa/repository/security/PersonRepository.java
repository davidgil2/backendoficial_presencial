package co.udea.airline.api.model.jpa.repository.security;

import org.springframework.data.jpa.repository.JpaRepository;

import co.udea.airline.api.model.jpa.model.security.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
    
}
