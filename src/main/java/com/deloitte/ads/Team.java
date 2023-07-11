package com.deloitte.ads;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Team {
    private Set<User> teamMembers;
    private List<Marios> receivedMarios;
    private String teamName;

    public Team(String teamName) {
        this.teamMembers = new HashSet<>();
        this.receivedMarios = new ArrayList<>();
        this.teamName = teamName;
    }

    public void addUserToTeam(User user){
        this.teamMembers.add(user);
    }

    @Override
    public String toString(){
        return this.teamName.toUpperCase();
    }
}
