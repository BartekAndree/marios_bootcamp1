package com.deloitte.ads.marios.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "marios")
public class Marios {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String type;
    private String comment;
    private LocalDateTime timestamp;
    @ManyToOne
    @JoinColumn(name = "sender_id")
    private User sender;
    @ManyToOne
    @JoinColumn(name = "receiver_id")
    private User receiver;

    public Marios(Long id, String type, String comment,
                  User sender,
                  User receiver) {
        this.id = id;
        this.type = type;
        this.comment = comment;
        this.timestamp = LocalDateTime.now();
        this.sender = sender;
        this.receiver = receiver;
    }

    public Marios(String type, String comment,
                  User sender,
                  User receiver) {
        this.type = type;
        this.comment = comment;
        this.timestamp = LocalDateTime.now();
        this.sender = sender;
        this.receiver = receiver;
    }

    public Marios() {

    }

    public Long getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getComment() {
        return comment;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public User getSender() {
        return sender;
    }

    public User getReceiver() {
        return receiver;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }

    @Override
    public String toString() {
        return this.type;
    }

//    APPRECIATION("Appreciation"),
//    TEAMWORK("Teamwork"),
//    LEADERSHIP("Leadership"),
//    CREATIVITY("Creativity"),
//    PROBLEM_SOLVING("Problem Solving");
}