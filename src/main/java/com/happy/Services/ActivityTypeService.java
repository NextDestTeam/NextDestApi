package com.happy.Services;

import com.happy.DTO.ActivityTypeDTO;
import com.happy.Exceptions.ActivityTypeNotFoundException;
import com.happy.Models.ActivityType;
import com.happy.Repositories.ActivityTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ActivityTypeService {
    @Autowired
    ActivityTypeRepository activityTypeRepository;

    public List<ActivityType> getAllActivityTypes(){
        return activityTypeRepository.findAll();
    }

    public ActivityType getActivityById(Integer id){
        return activityTypeRepository.findById(id)
                .orElseThrow(() -> new ActivityTypeNotFoundException(id));
    }

    public ActivityType addOrReplace(ActivityTypeDTO newActivityType, Integer id){
        return activityTypeRepository.findById(id)
                .map(activityType -> {
                    activityType.setName(newActivityType.getName());
                    return activityTypeRepository.save(activityType);
                }).orElseGet(() ->{
                    ActivityType activityType = new ActivityType();
                    activityType.setId(id);
                    activityType.setName(newActivityType.getName());
                    return activityTypeRepository.save(activityType);
                });
    }

    public ActivityType newActivity(ActivityTypeDTO newActivity){
        ActivityType activityType = new ActivityType();
        activityType.setName(newActivity.getName());
        return activityTypeRepository.save(activityType);
    }

    public void deleteActivityById(Integer id){
        activityTypeRepository.deleteById(id);
    }


}
