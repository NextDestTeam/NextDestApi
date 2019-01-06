package com.happy.Models;

import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

import java.util.List;

import static javax.persistence.GenerationType.SEQUENCE;

@Data
@Entity
@Table(name = "activity_type")
public class ActivityType {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "activityType", cascade = CascadeType.PERSIST)
    @JsonIdentityReference(alwaysAsId = true)
    @JsonIgnore
    private List<Activity> activities;

    @OneToMany(mappedBy = "activityTypeId", cascade = CascadeType.PERSIST)
    @JsonIdentityReference(alwaysAsId = true)
    @JsonIgnore
    private List<PersonPreference> preferences;

    public ActivityType() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Activity> getActivities() {
        return activities;
    }

    public void setActivities(List<Activity> activities) {
        this.activities = activities;
    }

    public List<PersonPreference> getPreferences() {
        return preferences;
    }

    public void setPreferences(List<PersonPreference> preferences) {
        this.preferences = preferences;
    }
}
