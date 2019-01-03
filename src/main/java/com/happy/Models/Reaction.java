package com.happy.Models;

import lombok.Data;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Data
@Entity
@Table(name = "reaction")
public class Reaction {
    @Id
    @GeneratedValue(strategy=SEQUENCE)
    @Column(name = "id")
    private Integer id;

    @Column(name = "reaction")
    private String reaction;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "personReactionId", referencedColumnName = "id")
    private Person personReactionId;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "activityReactionId", referencedColumnName = "id")
    private Activity activityReactionId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReaction() {
        return reaction;
    }

    public void setReaction(String reaction) {
        this.reaction = reaction;
    }

    public Person getPersonReactionId() {
        return personReactionId;
    }

    public void setPersonReactionId(Person personReactionId) {
        this.personReactionId = personReactionId;
    }

    public Activity getActivityReactionId() {
        return activityReactionId;
    }

    public void setActivityReactionId(Activity activityReactionId) {
        this.activityReactionId = activityReactionId;
    }
}
