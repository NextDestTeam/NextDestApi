package com.happy.Models;

import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

import java.util.Date;
import java.util.List;

import static javax.persistence.GenerationType.SEQUENCE;

@Data
@Entity
@Table(name = "activity")
public class Activity {
    @Id
    @GeneratedValue(strategy=SEQUENCE)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "short_description")
    private String shortDescription;

    @Column(name = "description")
    private String description;

    @Column(name = "location")
    private String location;

    @Column(name = "price")
    private Integer price;

    @Column(name = "date")
    private Date date;

    @Column(name = "image")
    private String image;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "person", referencedColumnName = "id")
    private Person person;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "activityType", referencedColumnName = "id")
    private ActivityType activityType;

    @OneToMany(mappedBy = "activityId", cascade = CascadeType.PERSIST)
    @JsonIdentityReference(alwaysAsId = true)
    @JsonIgnore
    private List<PersonActivityComment> personActivityComments;

    @OneToMany(mappedBy = "activityReactionId", cascade = CascadeType.PERSIST)
    @JsonIdentityReference(alwaysAsId = true)
    @JsonIgnore
    private List<Reaction> reactions;

    public List<Reaction> getReactions() {
        return reactions;
    }

    public void setReactions(List<Reaction> reactions) {
        this.reactions = reactions;
    }

    public Activity() {
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

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public ActivityType getEventType() {
        return activityType;
    }

    public void setEventType(ActivityType eventType) {
        this.activityType = eventType;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<PersonActivityComment> getPersonActivityComments() {
        return personActivityComments;
    }

    public void setPersonActivityComments(List<PersonActivityComment> personActivityComments) {
        this.personActivityComments = personActivityComments;
    }

    public ActivityType getActivityType() {
        return activityType;
    }

    public void setActivityType(ActivityType activityType) {
        this.activityType = activityType;
    }
}
