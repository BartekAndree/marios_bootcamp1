package com.deloitte.ads.marios.repository;

import jdk.jfr.Enabled;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "given_marios")
    @OneToMany(mappedBy = "marios",
            cascade = {CascadeType.ALL})
    private List<Marios> givenMarios;
    @Column(name = "received_marios")
    @OneToMany(mappedBy = "marios",
            cascade = {CascadeType.ALL})
    private List<Marios> receivedMarios;

    public User(int id, String firstName, String lastName) {
        this.id = id;
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
        return this.firstName.toUpperCase()
                + " "
                + this.lastName.toUpperCase();
    }


}
