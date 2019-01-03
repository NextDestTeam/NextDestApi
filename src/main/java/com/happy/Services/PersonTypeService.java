package com.happy.Services;

import com.happy.DTO.PersonTypeDTO;
import com.happy.Exceptions.PersonTypeNorFoundException;
import com.happy.Models.PersonType;
import com.happy.Repositories.PersonTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PersonTypeService {
    @Autowired
    private PersonTypeRepository personTypeRepository;

    public List<PersonType> getAllPersonTypes(){
        return personTypeRepository.findAll();
    }

    public PersonType getPersonTypeById(Integer id){
        return personTypeRepository.findById(id)
                .orElseThrow(() -> new PersonTypeNorFoundException(id));
    }

    public PersonType newPersonType(PersonTypeDTO newPersonType){
        PersonType personType = new PersonType();

        personType.setName(newPersonType.getName());
        return personTypeRepository.save(personType);
    }

    public PersonType addOrReplace(PersonTypeDTO newPersonType, Integer id){
        return personTypeRepository.findById(id)
                .map(personType -> {
                    personType.setName(newPersonType.getName());
                    return personTypeRepository.save(personType);
                })
                .orElseGet(() -> {
                    PersonType personType = new PersonType();
                    personType.setId(id);
                    personType.setName(newPersonType.getName());
                    return personTypeRepository.save(personType);
                });
    }

    public void removePersonType(Integer id){
        personTypeRepository.deleteById(id);
    }
}
