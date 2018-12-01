package com.happy.Controllers;

import com.happy.Exceptions.PersonTypeNorFoundException;
import com.happy.Models.PersonType;
import com.happy.Repositories.PersonTypeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class PersonTypeController {
    private final PersonTypeRepository repository;

    public PersonTypeController(PersonTypeRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/personTypes")
    public List<PersonType> findAllPersonTypes(){
        return repository.findAll();
    }

    @GetMapping("/personType/{id}")
    public PersonType findPersonTypeById(@PathVariable Integer id){
        return repository.findById(id)
                .orElseThrow(() -> new PersonTypeNorFoundException(id));
    }

    @PostMapping("/persons")
    public PersonType newType(@RequestBody PersonType personType){
        return repository.save(personType);
    }

    @DeleteMapping("/person/{id}")
    public void deletePersonType(@PathVariable Integer id){
        repository.deleteById(id);
    }
}
