package com.happy.Controllers;

import com.happy.DTO.PersonDTO;
import com.happy.Exceptions.PersonNotFoundException;
import com.happy.Repositories.PersonRepository;
import com.happy.Models.Person;
import com.happy.Services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {

    @Autowired
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/persons")
    public List<Person> getAllPersons(){
        return personService.findAllPersons();
    }

    @GetMapping("/personName/{name}")
    public Person getPersonByName(@PathVariable String name){
        return personService.findByName(name);
    }

    @PostMapping("/persons")
    public Person newPerson(@RequestBody PersonDTO person){
        return personService.newPerson(person);
    }

    @GetMapping("/person/{id}")
    public Person getPersonById(@PathVariable  Integer id){
        return personService.findPersonById(id);
    }

    @PutMapping("/person/{id}")
    public Person createOrReplacePerson(@RequestBody PersonDTO newPerson, @PathVariable Integer id){
        return personService.addOrReplace(newPerson, id);
    }

    @DeleteMapping("/person/{id}")
    public void deletePerson(@PathVariable Integer id){
        personService.deletePersonById(id);
    }
}
