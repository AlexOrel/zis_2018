package com.hellokoding.springboot.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by orlov on 10.12.16.
 */
@Entity
public class PersonVote extends TransactionalEntity implements Serializable{


    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "personId", nullable = false)
    private Person person;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "voteId", nullable = false)
    private Vote vote;

    private Boolean voted;

    public PersonVote(){

    }

    public PersonVote(Person person, Vote vote, Boolean voted){
        this.person = person;
        this.vote = vote;
        this.voted = voted;
    }


    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Vote getVote() {
        return vote;
    }

    public void setVote(Vote vote) {
        this.vote = vote;
    }

    public Boolean getVoted() {
        return voted;
    }

    public void setVoted(Boolean voted) {
        this.voted = voted;
    }
}
