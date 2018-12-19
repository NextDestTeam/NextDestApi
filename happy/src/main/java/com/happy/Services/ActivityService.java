package com.happy.Services;

import com.happy.DTO.ActivityDTO;
import com.happy.DTO.ActivityFilterDTO;
import com.happy.Exceptions.ActivityNotFoundException;
import com.happy.Exceptions.ActivityTypeNotFoundException;
import com.happy.Exceptions.PersonNotFoundException;
import com.happy.Models.Activity;
import com.happy.Models.ActivityType;
import com.happy.Models.Person;
import com.happy.Repositories.ActivityRepository;
import com.happy.Repositories.ActivityTypeRepository;
import com.happy.Repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Component
public class ActivityService {
    @Autowired
    private ActivityRepository activityRepository;

    @Autowired
    private ActivityTypeRepository activityTypeRepository;

    @Autowired
    private PersonRepository personRepository;

    public List<Activity> getAllActivities(){
        return activityRepository.findAll();
    }

    public List<Activity> getAllActivitiesByFilter(ActivityFilterDTO filter){
        Set<Activity> activitySet = new LinkedHashSet<>();
        List<Activity> activities = new ArrayList<>();

        if(filter == null){
            return this.getAllActivities();
        }else{
            if (filter.getName() != null){
                activitySet.addAll(activityRepository.findActivitiesByNameContains(filter.getName()));
            }
            if(filter.getActivityTypeId() != null){
                ActivityType activityType = activityTypeRepository.findById(filter.getActivityTypeId())
                        .orElseThrow(() -> new ActivityTypeNotFoundException(filter.getActivityTypeId()));
                activitySet.addAll(activityRepository.findActivitiesByActivityType(activityType));
            }

            if(filter.getPrice() != null){
                activitySet.addAll(activityRepository.findActivitiesByPrice(filter.getPrice()));
            }
        }
        activities.addAll(activitySet);

        return activities;
    }

    public Activity getActivityById(Integer id){
        return activityRepository.findById(id)
                .orElseThrow(() -> new ActivityNotFoundException(id));
    }

    public Activity addOrReplace(ActivityDTO newActivity, Integer id){
        Person p = personRepository.findById(newActivity.getPerson())
                .orElseThrow(() -> new PersonNotFoundException(newActivity.getPerson()));
        ActivityType a = activityTypeRepository.findById(newActivity.getActivityType())
                .orElseThrow(() -> new ActivityNotFoundException(newActivity.getActivityType()));

        return activityRepository.findById(id)
                .map(activity -> {
                    return getActivity(newActivity, a, activity);
                }).orElseGet(() ->{
                    Activity activity = new Activity();
                    activity.setId(id);
                    return getActivity(newActivity, a, activity);
                });
    }

    public Activity newActivity(ActivityDTO newActivity){
        Activity activity = new Activity();
        Person p;
        p = personRepository.findById(newActivity.getPerson())
                .orElseThrow(() -> new PersonNotFoundException(newActivity.getPerson()));
        ActivityType a;
        a = activityTypeRepository.findById(newActivity.getActivityType())
                .orElseThrow(() -> new ActivityNotFoundException(newActivity.getActivityType()));
        activity.setDate(newActivity.getDate());
        activity.setDescription(newActivity.getDescription());
        activity.setActivityType(a);
        activity.setImage(newActivity.getImage());
        activity.setLocation(newActivity.getLocation());
        activity.setName(newActivity.getName());
        activity.setPerson(p);
        activity.setPrice(newActivity.getPrice());
        activity.setShortDescription(newActivity.getShortDescription());

        return activityRepository.save(activity);
    }

    public void deleteActivityById(Integer id){
        activityRepository.deleteById(id);
    }

    private Activity getActivity(ActivityDTO newActivity, ActivityType a, Activity activity) {
        activity.setDate(newActivity.getDate());
        activity.setDescription(newActivity.getDescription());
        activity.setActivityType(a);
        activity.setImage(newActivity.getImage());
        activity.setLocation(newActivity.getLocation());
        activity.setName(newActivity.getName());
        activity.setPrice(newActivity.getPrice());
        activity.setShortDescription(newActivity.getShortDescription());

        return activityRepository.save(activity);
    }
}
