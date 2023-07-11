package com.deloitte.ads;

import java.util.ArrayList;
import java.util.List;

public class User {

    private String firstName;
    private String lastName;
    private List<Marios> givenMarios;
    private List<Marios> receivedMarios;

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.givenMarios = new ArrayList<>();
        this.receivedMarios = new ArrayList<>();
    }
    public void giveMariosToUser(User user, Marios marios){
        user.receivedMarios.add(marios);
    }
    public List<Marios> showUserReceivedMarios(){
        return receivedMarios;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString(){
        return this.firstName.toUpperCase()
                + " "
                + this.lastName.toUpperCase();
    }


}
