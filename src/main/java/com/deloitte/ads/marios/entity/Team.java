package com.deloitte.ads.marios.entity;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private int id;
    private String name;
    private List<User> members;
    private List<Marios> receivedMarios;


    public Team(int id, String teamName) {
        this.id = id;
        this.name = teamName;
        this.members = new ArrayList<>();
        this.receivedMarios = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<User> getMembers() {
        return members;
    }

    public List<Marios> getReceivedMarios() {
        return receivedMarios;
    }

    public void addUserToTeam(User user) {
        this.members.add(user);
    }

    @Override
    public String toString() {
        return this.name.toUpperCase();
    }
}
