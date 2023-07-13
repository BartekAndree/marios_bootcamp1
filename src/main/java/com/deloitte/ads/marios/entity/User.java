package com.deloitte.ads.marios.entity;

import com.deloitte.ads.marios.entity.Marios;

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
    @OneToMany(mappedBy = "sender")
    private List<Marios> givenMarios;
    @OneToMany(mappedBy = "receiver")
    private List<Marios> receivedMarios;

    public User(Long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.givenMarios = new ArrayList<>();
        this.receivedMarios = new ArrayList<>();
    }

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
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

    public List<Marios> getGivenMarios() {
        return givenMarios;
    }

    public List<Marios> getReceivedMarios() {
        return receivedMarios;
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
