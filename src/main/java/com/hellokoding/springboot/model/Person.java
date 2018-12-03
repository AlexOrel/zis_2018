package com.hellokoding.springboot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Set;

/**
 * Created by sanyaorel on 19.05.16.
 */
@Entity
@Table(name = "Person")
public class Person extends TransactionalEntity{

    private static final int serialVersionUID = 1;

    @NotNull
    private String name;

    @NotNull
    private String middleName;

    @NotNull
    private String surName;

    @NotNull
    private String address;

    @NotNull
    private String phone;

    @NotNull
    private Date birthdate;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "person")
    private Set<PersonVote> personVotes;


    public Person(){
    }

    public Person(String name, String middleName,String surName, String address,
                  String phone,Date birthdate){
        super();
        this.name = name;
        this.middleName = middleName;
        this.surName = surName;
        this.address = address;
        this.phone = phone;
        this.birthdate = birthdate;
    }

    public Person(Integer id, String name,  String middleName,String surName, String address,
                  String phone,Date birthdate){
        super();
        this.setId(id);
        this.name = name;
        this.middleName = middleName;
        this.surName = surName;
        this.address = address;
        this.phone = phone;
        this.birthdate = birthdate;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public Set<PersonVote> getPersonVotes() {
        return personVotes;
    }

    public void setPersonVotes(Set<PersonVote> personVotes) {
        this.personVotes = personVotes;
    }
}