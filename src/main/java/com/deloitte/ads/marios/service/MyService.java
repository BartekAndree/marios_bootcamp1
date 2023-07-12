package com.deloitte.ads.marios.service;

import com.deloitte.ads.marios.repository.Marios;
import com.deloitte.ads.marios.repository.Team;
import com.deloitte.ads.marios.repository.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MyService {
    private List<User> usersList;
    private List<Team> teamsList;
    private List<Marios> mariosList;

    public MyService() {
        User u1 = new User(1, "Bartek", "Andree");
        User u2 = new User(2, "Kinga", "Banach");
        User u3 = new User(3, "Mateusz", "Zwierzlak");
        User u4 = new User(4, "Bartek", "Szymanski");
        Marios m1 = new Marios(1, "Good job", "You are the best", u1, u2);
        Marios m2 = new Marios(2, "Thanks", "You are the best", u1, u3);
        Marios m3 = new Marios(3, "Nice to have you", "You are the best", u1, u4);
        Marios m4 = new Marios(4, "Good job", "You are the best", u2, u1);
        Marios m5 = new Marios(5, "Thanks", "You are the best", u2, u3);
        this.usersList = List.of(u1, u2, u3, u4);
        this.mariosList = List.of(m1, m2, m3, m4, m5);
    }

    public void addMarios(int senderId, int receiverId, String type, String comment) {
        User sender = findUserById(senderId);
        User receiver = findUserById(receiverId);

        if (sender != null && receiver != null) {
            Marios marios = new Marios(
                    generateMariosId(),
                    type,
                    comment,
                    sender,
                    receiver);
            sender.addGivenMarios(marios);
            receiver.addReceivedMarios(marios);
            this.mariosList.add(marios);
        }
    }
    public void addUser(String firstName, String lastName){
        if (firstName != null && lastName != null){
            User user = new User(generateUserId(),
                    firstName, lastName);
            this.usersList.add(user);
        }
    }

    public List<Marios> getUserReceivedMarios(int userId) {
        User user = findUserById(userId);
        return this.mariosList.stream()
                .filter(marios -> marios.getReceiver().equals(user))
                .collect(Collectors.toList());
    }

    public List<Marios> getUserGivenMarios(int userId) {
        User user = findUserById(userId);
        return this.mariosList.stream()
                .filter(marios -> marios.getSender().equals(user))
                .collect(Collectors.toList());
    }

    public List<Marios> getUserAllMarios(int userId) {
        User user = findUserById(userId);
        return this.mariosList.stream()
                .filter(marios -> marios.getSender().equals(user) || marios.getReceiver().equals(user))
                .collect(Collectors.toList());
    }

    public List<Marios> getAllMarios() {
        return this.mariosList;
    }
    public List<User> getAllUsers(){
        return this.usersList;
    }

    private int generateMariosId() {
        return this.mariosList.size() + 1;
    }
    private int generateUserId(){ return this.usersList.size() + 1; }

    public User findUserById(int senderId) {
        return this.usersList.stream()
                .filter(user -> user.getId() == senderId)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
    public Marios findMariosById(int mariosId){
        return  this.mariosList.stream()
                .filter(marios -> marios.getId() == mariosId)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Marios not found"));
    }
}
