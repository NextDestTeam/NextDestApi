package com.happy.Controllers;

import com.happy.DTO.PersonPreferenceDTO;
import com.happy.Models.PersonPreference;
import com.happy.Services.PersonPreferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonPreferenceController {
    @Autowired
    private PersonPreferenceService preferenceService;

    @GetMapping("/personPreferences")
    public List<PersonPreference> getAllPreferences(){
        return preferenceService.getAllPreferences();
    }

    @GetMapping("/personPreference/{id}")
    public PersonPreference getPreference(@PathVariable Integer id){
        return preferenceService.getPreference(id);
    }

    @PostMapping("/personPreferences")
    public PersonPreference newPersonPreference(@RequestBody PersonPreferenceDTO preference){
        return preferenceService.addNewPreference(preference);
    }

    @PutMapping("/personPreference/{id}")
    public PersonPreference addOrReplacePreference(@RequestBody PersonPreferenceDTO preference, @PathVariable Integer id){
        return preferenceService.addOrReplacePreference(preference, id);
    }

    @DeleteMapping("/personPreference/{id}")
    public void deletePreference(Integer id){
        preferenceService.deletePreference(id);
    }
}
