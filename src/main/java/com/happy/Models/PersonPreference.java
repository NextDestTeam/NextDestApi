package com.happy.Models;


import lombok.Data;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Data
@Entity
@Table(name = "person_preference")
public class PersonPreference {
    @Id
    @GeneratedValue(strategy=SEQUENCE)
    @Column(name = "id")
    private Integer id;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "personId", referencedColumnName = "id")
    private Person personPreferenceId;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "activityTypeId", referencedColumnName = "id")
    private ActivityType activityTypeId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Person getPersonPreferenceId() {
        return personPreferenceId;
    }

    public void setPersonPreferenceId(Person personPreferenceId) {
        this.personPreferenceId = personPreferenceId;
    }

    public ActivityType getActivityTypeId() {
        return activityTypeId;
    }

    public void setActivityTypeId(ActivityType activityTypeId) {
        this.activityTypeId = activityTypeId;
    }
}
