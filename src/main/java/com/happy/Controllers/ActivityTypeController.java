package com.happy.Controllers;

import com.happy.DTO.ActivityTypeDTO;
import com.happy.Models.ActivityType;
import com.happy.Services.ActivityTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ActivityTypeController {
    @Autowired
    private ActivityTypeService activityTypeService;

    @GetMapping("/activityTypes")
    public List<ActivityType> getAllActivityTypes(){
        return activityTypeService.getAllActivityTypes();
    }

    @GetMapping("/activityType/{id}")
    public ActivityType getActivityType(@PathVariable Integer id){
        return activityTypeService.getActivityById(id);
    }

    @PutMapping("/activityType/{id}")
    public ActivityType addOrReplaceActivityType(@RequestBody ActivityTypeDTO activityType, @PathVariable Integer id){
        return activityTypeService.addOrReplace(activityType, id);
    }

    @PostMapping("/activityTypes")
    public ActivityType addActivityType(@RequestBody ActivityTypeDTO activityType){
        return activityTypeService.newActivity(activityType);
    }

    @DeleteMapping("/activityType/{id}")
    public void deleteActivityType(@PathVariable Integer id){
        activityTypeService.deleteActivityById(id);
    }
}
