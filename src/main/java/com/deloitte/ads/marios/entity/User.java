package com.deloitte.ads.marios.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.checkerframework.common.aliasing.qual.Unique;
import org.springframework.beans.factory.annotation.Required;

import javax.annotation.RegEx;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    @Column(unique=true)
    private String email;
    @JsonIgnore
    @OneToMany(mappedBy = "sender")
    private List<Marios> givenMarios;
    @JsonIgnore
    @OneToMany(mappedBy = "receiver")
    private List<Marios> receivedMarios;


    public User(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.givenMarios = new ArrayList<>();
        this.receivedMarios = new ArrayList<>();
    }

    public User() {

    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Marios> getGivenMarios() {
        return givenMarios;
    }

    public List<Marios> getReceivedMarios() {
        return receivedMarios;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setGivenMarios(List<Marios> givenMarios) {
        this.givenMarios = givenMarios;
    }

    public void setReceivedMarios(List<Marios> receivedMarios) {
        this.receivedMarios = receivedMarios;
    }

    public void addGivenMarios(Marios marios) {
        this.givenMarios.add(marios);
    }

    public void addReceivedMarios(Marios marios) {
        this.receivedMarios.add(marios);
    }

    @Override
    public String toString() {
        return this.firstName.toUpperCase() + " " + this.lastName.toUpperCase();
    }


}
