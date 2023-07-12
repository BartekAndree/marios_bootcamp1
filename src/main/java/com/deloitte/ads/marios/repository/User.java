package com.deloitte.ads.marios.repository;

import java.util.ArrayList;
import java.util.List;

public class User {

    private final int id;
    private String firstName;
    private String lastName;
    private List<Marios> givenMarios;
    private List<Marios> receivedMarios;

    public User(int id,String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.givenMarios = new ArrayList<>();
        this.receivedMarios = new ArrayList<>();
    }

    public int getId() {
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
    public void addGivenMarios(Marios marios){
        this.givenMarios.add(marios);
    }
    public void addReceivedMarios(Marios marios){
        this.receivedMarios.add(marios);
    }

    @Override
    public String toString(){
        return this.firstName.toUpperCase()
                + " "
                + this.lastName.toUpperCase();
    }


}
