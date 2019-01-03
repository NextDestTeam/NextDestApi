package com.happy.Controllers;

import com.happy.DTO.PersonTypeDTO;
import com.happy.Exceptions.PersonTypeNorFoundException;
import com.happy.Models.PersonType;
import com.happy.Services.PersonTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonTypeController {
    @Autowired
    private final PersonTypeService personTypeService;

    public PersonTypeController(PersonTypeService personTypeService) {
        this.personTypeService = personTypeService;
    }

    @GetMapping("/personTypes")
    public List<PersonType> findAllPersonTypes(){
        return personTypeService.getAllPersonTypes();
    }

    @GetMapping("/personType/{id}")
    public PersonType findPersonTypeById(@PathVariable Integer id){
        return personTypeService.getPersonTypeById(id);
    }

    @PutMapping("/personType/{id}")
    public PersonType createOrReplacePersonType(@RequestBody PersonTypeDTO personType, @PathVariable Integer id){
        return personTypeService.addOrReplace(personType, id);
    }

    @PostMapping("/personTypes")
    public PersonType newType(@RequestBody PersonTypeDTO personType){
        return personTypeService.newPersonType(personType);
    }

    @DeleteMapping("/personType/{id}")
    public void deletePersonType(@PathVariable Integer id){
        personTypeService.removePersonType(id);
    }
}
