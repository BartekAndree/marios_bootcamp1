package com.deloitte.ads;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class User {

    private String firstName;
    private String lastName;
    private List<Marios> givenMarios;
    private List<Marios> receivedMarios;

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        givenMarios = new ArrayList<>();
        receivedMarios = new ArrayList<>();
    }
    public void giveMariosToUser(User user, Marios marios){
        user.receivedMarios.add(marios);
    }
    public List<Marios> showUserReceivedMarios(){
        return receivedMarios;
    }

}
