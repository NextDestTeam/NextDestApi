package com.happy.Models;

import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Data
@Entity
@Table(name = "image")
public class Image {
    @Id
    @GeneratedValue(strategy=SEQUENCE)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "imageid")
    private byte[] imageid;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "imageActivityId")
    @JsonIdentityReference(alwaysAsId = true)
    @JsonIgnore
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
