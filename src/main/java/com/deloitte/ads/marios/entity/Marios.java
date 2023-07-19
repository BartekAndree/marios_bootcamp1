package com.deloitte.ads.marios.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity(name = "marios")
public class Marios {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Type(type = "uuid-char")
    @Column(unique = true)
    private UUID uuid = UUID.randomUUID();

    private String type;

    private String comment;

    private LocalDateTime timestamp;

    @ManyToOne
    @JoinColumn(name = "sender_id")
    private User sender;

    @ManyToOne
    @JoinColumn(name = "receiver_id")
    private User receiver;


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