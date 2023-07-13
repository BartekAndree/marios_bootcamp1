package com.deloitte.ads.marios.repository;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "marios")
public class Marios {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "type")
    private String type;
    @Column(name = "comment")
    private String comment;
    @Column(name = "time_stamp")
    private LocalDateTime timestamp;
    @Column(name = "sender")
    @OneToOne(mappedBy = "user")
    private User sender;
    @Column(name = "receiver")
    @OneToOne(mappedBy = "user")
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


    @Override
    public String toString() {
        return this.type;
    }

//    public static String[] mariosTypes = new String[]{
//            "Dziękuję Za Pomoc",
//            "Doceniam Twoją Pracę",
//            "Twoje Umiejętności Programistyczne Są Niesamowite",
//            "Cieszę Si ęŻe Mogę Pracować Z Takim Utalentowanym Programistą",
//            "Twoje Rozwiązania Są Zawsze Innowacyjne I Skuteczne",
//    };


}