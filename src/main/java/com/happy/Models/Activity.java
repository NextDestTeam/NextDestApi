package com.happy.Models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import javax.persistence.*;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "activity")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
public class Activity {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
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

    @Column(name = "status")
    private String status;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private Person activityPerson;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "activity_type", referencedColumnName = "id")
    private ActivityType activityType;

    @OneToMany(mappedBy = "activityId", cascade = CascadeType.PERSIST)
    @JsonIdentityReference(alwaysAsId = true)
    @JsonIgnore
    private List<PersonActivityComment> personActivityComments;

    @OneToMany(mappedBy = "activityReactionId", cascade = CascadeType.PERSIST)
    @JsonIdentityReference(alwaysAsId = true)
    @JsonIgnore
    private List<Reaction> reactions;

    @OneToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "image_id", referencedColumnName="id")
    private Image imageActivityId;

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

    public Person getActivityPerson() {
        return activityPerson;
    }

    public void setActivityPerson(Person activityPerson) {
        this.activityPerson = activityPerson;
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

    public Image getImageActivityId() {
        return imageActivityId;
    }

    public void setImageActivityId(Image imageActivityId) {
        this.imageActivityId = imageActivityId;
    }
}
