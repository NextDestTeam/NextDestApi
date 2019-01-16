package com.happy.Controllers;

import com.happy.DTO.ActivityDTO;
import com.happy.DTO.ActivityFilterDTO;
import com.happy.Models.Activity;
import com.happy.Services.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ActivityController {
    @Autowired
    ActivityService activityService;

    @GetMapping("/activities")
    public List<Activity> getAllActivities(){
        return activityService.getAllActivities().stream().filter(x->"P".equals(x.getStatus())).collect(Collectors.toList());
    }

    @GetMapping("/activitiesId")
    public List<Integer> getAllActivitiesId(){
        List<Integer> ids = new ArrayList<>();
        List<Activity> activities = activityService.getAllActivities();
        for (Activity a :
                activities) {
            if("P".equals(a.getStatus()))
                ids.add(a.getId());
        }
        return ids;
    }

    @GetMapping("/activitiesFilter&name={name}&activityType={at}&startDate={sd}&endDate={ed}&price={price}")
    public List<Activity> getAllActivitiesByFilter(@RequestParam(value = "name", required = false) String name,
                                                   @RequestParam(value = "at", required = false) Integer at,
                                                   @RequestParam(value = "price", required = false) Integer price){
        ActivityFilterDTO filter = new ActivityFilterDTO();
        filter.setActivityTypeId(at);
        filter.setName(name);
        filter.setPrice(price);
        return activityService.getAllActivitiesByFilter(filter);
    }

    @GetMapping("/activity/{id}")
    public Activity getActivity(@PathVariable Integer id){
        return activityService.getActivityById(id);
    }

    @PutMapping("/activity/{id}")
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
