package com.happy.Controllers;

import com.happy.DTO.ActivityDTO;
import com.happy.Models.Activity;
import com.happy.Services.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ActivityController {
    @Autowired
    ActivityService activityService;

    @GetMapping("/activities")
    public List<Activity> getAllActivities(){
        return activityService.getAllActivities();
    }

    @GetMapping("/activity/{id}")
    public Activity getActivity(@PathVariable Integer id){
        return activityService.getActivityById(id);
    }

    @PostMapping("/activity/{id}")
    public Activity addOrReplaceActivity(@RequestBody ActivityDTO activity, @PathVariable Integer id){
        return activityService.addOrReplace(activity, id);
    }

    @PostMapping("/activities")
    public Activity newActivity(@RequestBody ActivityDTO activity){
        return activityService.newActivity(activity);
    }

    @DeleteMapping("/activity/{id}")
    public void removeActivity(@PathVariable Integer id){
        activityService.deleteActivityById(id);
    }
}
