package com.happy.Services;

import com.happy.DTO.ActivityDTO;
import com.happy.Exceptions.ActivityNotFoundException;
import com.happy.Exceptions.PersonNotFoundException;
import com.happy.Models.Activity;
import com.happy.Models.ActivityType;
import com.happy.Models.Person;
import com.happy.Repositories.ActivityRepository;
import com.happy.Repositories.ActivityTypeRepository;
import com.happy.Repositories.PersonRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ActivityService {
    private ActivityRepository activityRepository;
    private ActivityTypeRepository activityTypeRepository;
    private PersonRepository personRepository;

    public List<Activity> getAllActivities(){
        return activityRepository.findAll();
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
                    return getActivity(newActivity, p, a, activity);
                }).orElseGet(() ->{
                    Activity activity = new Activity();
                    activity.setId(id);
                    return getActivity(newActivity, p, a, activity);
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
        return getActivity(newActivity, p, a, activity);
    }

    public void deleteActivityById(Integer id){
        activityRepository.deleteById(id);
    }

    private Activity getActivity(ActivityDTO newActivity, Person p, ActivityType a, Activity activity) {
        activity.setDate(newActivity.getDate());
        activity.setDescription(newActivity.getDescription());
        activity.setEventType(a);
        activity.setImage(newActivity.getImage());
        activity.setLocation(newActivity.getLocation());
        activity.setName(newActivity.getName());
        activity.setPerson(p);
        activity.setPrice(newActivity.getPrice());
        activity.setShortDescription(newActivity.getShortDescription());

        return activityRepository.save(activity);
    }
}
