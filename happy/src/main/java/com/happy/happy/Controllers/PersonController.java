package com.happy.happy.Controllers;

import com.happy.happy.Exceptions.PersonNotFoundException;
import com.happy.happy.Models.Person;
import com.happy.happy.Repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {
    private final PersonRepository personRepository;

    public PersonController(PersonRepository personRepository){
        this.personRepository = personRepository;
    }

    @GetMapping("/persons")
    public List<Person> getAllPersons(){
        return personRepository.findAll();
    }

    @PostMapping("/persons")
    public Person newPerson(@RequestBody Person person){
        return personRepository.save(person);
    }

    @GetMapping("/person/{id}")
    public Person getPersonById(@PathVariable  Integer id){
        return personRepository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException(id));
    }

    @PutMapping("/person/{id}")
    public Person createOrReplacePerson(@RequestBody Person newPerson, @PathVariable Integer id){
        return personRepository.findById(id)
                .map(person -> {
                    person.setFirstName(newPerson.getFirstName());
                    person.setLastName(newPerson.getLastName());
                    person.setEmail(newPerson.getEmail());
                    person.setAge(newPerson.getAge());
                    person.setPersonTypeId(newPerson.getPersonTypeId());
                    return personRepository.save(person);
                })
                .orElseGet(() -> {
                    newPerson.setId(id);
                    return personRepository.save(newPerson);
                });
    }

    @DeleteMapping("/person/{id}")
    public void deletePerson(@PathVariable Integer id){
        personRepository.deleteById(id);
    }
}
