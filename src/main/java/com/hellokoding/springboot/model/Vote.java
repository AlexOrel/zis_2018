package com.hellokoding.springboot.model;

import com.sun.istack.internal.Nullable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.util.Date;
import java.util.Set;

/**
 * Created by orlov on 10.12.16.
 */
@Entity
public class Vote extends TransactionalEntity{

    private static final int serialVersionUID = 1;

    @NotNull
    private Date dateTime;

    @NotNull
    private String address;

    @Nullable
    private String description;

    public Vote()
    {
    }

    public Vote(Date dateTime, String address, String description)
    {
        this.dateTime = dateTime;
        this.address = address;
        this.description = description;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "vote")
    private Set<PersonVote> personVotes;

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<PersonVote> getPersonVotes() {
        return personVotes;
    }

    public void setPersonVotes(Set<PersonVote> personVotes) {
        this.personVotes = personVotes;
    }
}
