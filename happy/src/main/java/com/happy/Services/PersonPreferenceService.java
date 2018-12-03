package com.happy.Services;

import com.happy.DTO.PersonPreferenceDTO;
import com.happy.Exceptions.ActivityTypeNotFoundException;
import com.happy.Exceptions.PersonNotFoundException;
import com.happy.Exceptions.PersonPreferenceNotFoundException;
import com.happy.Models.ActivityType;
import com.happy.Models.Person;
import com.happy.Models.PersonPreference;
import com.happy.Repositories.ActivityTypeRepository;
import com.happy.Repositories.PersonPreferenceRepository;
import com.happy.Repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PersonPreferenceService {
    @Autowired
    private PersonPreferenceRepository preferenceRepository;

    @Autowired
    private ActivityTypeRepository activityTypeRepository;

    @Autowired
    private PersonRepository personRepository;

    public List<PersonPreference> getAllPreferences(){
        return preferenceRepository.findAll();
    }

    public PersonPreference getPreference(Integer id){
        return preferenceRepository.findById(id)
                .orElseThrow(() -> new PersonPreferenceNotFoundException(id));
    }

    public PersonPreference addNewPreference(PersonPreferenceDTO newPreference){
        return getPersonPreference(newPreference);
    }

    public PersonPreference addOrReplacePreference(PersonPreferenceDTO newPreference, Integer id){
        ActivityType activityType = activityTypeRepository.findById(newPreference.getActivityTypeId())
                .orElseThrow(() -> new ActivityTypeNotFoundException(newPreference.getActivityTypeId()));
        return preferenceRepository.findById(id)
                .map(preference -> {
                    preference.setActivityTypeId(activityType);
                     return preferenceRepository.save(preference);
                }).orElseGet(() ->{
                    return getPersonPreference(newPreference);
                });
    }

    public void deletePreference(Integer id){
        preferenceRepository.deleteById(id);
    }

    private PersonPreference getPersonPreference(PersonPreferenceDTO newPreference) {
        PersonPreference preference = new PersonPreference();
        ActivityType activityType = activityTypeRepository.findById(newPreference.getActivityTypeId())
                .orElseThrow(() -> new ActivityTypeNotFoundException(newPreference.getActivityTypeId()));
        Person person = personRepository.findById(newPreference.getPersonPreferenceId())
                .orElseThrow(() -> new PersonNotFoundException(newPreference.getPersonPreferenceId()));

        preference.setActivityTypeId(activityType);
        preference.setPersonPreferenceId(person);

        return preferenceRepository.save(preference);
    }
}
