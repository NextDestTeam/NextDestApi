package com.happy.Models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Data
@Entity
@Table(name = "image")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
public class Image {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "image")
    private byte[] imageid;

    @OneToOne(mappedBy = "imageActivityId")
    private Activity activityImageId;

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

    public byte[] getImageid() {
        return imageid;
    }

    public void setImageid(byte[] imageid) {
        this.imageid = imageid;
    }

    public Activity getActivityImageId() {
        return activityImageId;
    }

    public void setActivityImageId(Activity activityImageId) {
        this.activityImageId = activityImageId;
    }
}
