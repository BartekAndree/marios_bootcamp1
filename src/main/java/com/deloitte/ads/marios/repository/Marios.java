package com.deloitte.ads.marios.repository;

import java.time.LocalDateTime;

public class Marios {

    private final int id;
    private String type;
    private String comment;
    private LocalDateTime timestamp;
    private final User sender;
    private final User receiver;

    public Marios(int id, String type, String comment,
                  User sender,
                  User receiver) {
        this.id = id;
        this.type = type;
        this.comment = comment;
        this.timestamp = LocalDateTime.now();
        this.sender = sender;
        this.receiver = receiver;
    }

    public int getId() {
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