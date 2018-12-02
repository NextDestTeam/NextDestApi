package com.happy.Services;

import com.happy.DTO.PersonDTO;
import com.happy.Exceptions.PersonNotFoundException;
import com.happy.Exceptions.PersonTypeNorFoundException;
import com.happy.Models.Person;
import com.happy.Models.PersonType;
import com.happy.Repositories.PersonRepository;
import com.happy.Repositories.PersonTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PersonTypeRepository personTypeRepository;

    public List<Person> findAllPersons(){
        return personRepository.findAll();
    }

    public Person findPersonById(Integer id){
        return personRepository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException(id));
    }

    public Person addOrReplace(PersonDTO newPerson, Integer id){
        PersonType personType = personTypeRepository.findById(newPerson.getPersonTypeId())
                .orElseThrow(() -> new PersonTypeNorFoundException(newPerson.getPersonTypeId()));
        return personRepository.findById(id)
                .map(person -> {
                    return getPerson(newPerson, personType, person);
                })
                .orElseGet(() -> {
                    Person p = new Person();
                    p.setId(id);
                    return getPerson(newPerson, personType, p);
                });
    }

    private Person getPerson(PersonDTO newPerson, PersonType personType, Person person) {
        person.setFirstName(newPerson.getFirstName());
        person.setLastName(newPerson.getLastName());
        person.setEmail(newPerson.getEmail());
        person.setAge(newPerson.getAge());
        person.setPersonTypeId(personType);
        return personRepository.save(person);
    }

    public Person newPerson(PersonDTO newPerson){
        Person p = new Person();

        PersonType personType = personTypeRepository.findById(newPerson.getPersonTypeId())
                .orElseThrow(() -> new PersonTypeNorFoundException(newPerson.getPersonTypeId()));

        return getPerson(newPerson, personType, p);
    }

    public void deletePersonById(Integer id){
        personRepository.deleteById(id);
    }
}
