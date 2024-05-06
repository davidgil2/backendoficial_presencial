package co.udea.airline.api.controller;
import co.udea.airline.api.model.jpa.model.Person;
import co.udea.airline.api.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/person")
public class PersonController {
    @Autowired
    private PersonService personService;

    @GetMapping("/persons")
    public List<Person> getPersons() {
        return personService.getPersons();
    }

    @GetMapping("/{personId}")
    public Optional<Person> getPersonById(@PathVariable long personId) {
        return personService.getPerson(personId);
    }

<<<<<<< HEAD
    @PostMapping("/person")
=======
    @PostMapping("person")
>>>>>>> 0e174b8491e87f11c2c6fb34a74f29fbb329c496
    public void savePerson(@RequestBody Person person) {
        personService.saveOrUpdate(person);
    }

    @DeleteMapping("/{personId}")
    public void deletePerson(@PathVariable Long personId){
        personService.delete(personId);
    }
}
