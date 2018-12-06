package com.happy.Repositories;

import com.happy.Models.Activity;
import com.happy.Models.ActivityType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface ActivityRepository extends JpaRepository<Activity, Integer> {
    public List<Activity> findActivitiesByActivityType(ActivityType activityType);
    public List<Activity> findActivitiesByPrice(Integer price);
    public List<Activity> findActivitiesByNameContains(String activityName);
    public List<Activity> findActivitiesByDateBetween(Date initialDate, Date endDate);
}
