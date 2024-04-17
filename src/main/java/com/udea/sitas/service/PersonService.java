package com.udea.sitas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.udea.sitas.model.Person;
import com.udea.sitas.model.repository.PersonRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    @Autowired
    PersonRepository personRepository;

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
