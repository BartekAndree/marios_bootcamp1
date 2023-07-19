package com.deloitte.ads.marios.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Type(type = "uuid-char")
    @Column(unique = true)
    private UUID uuid = UUID.randomUUID();

    private String firstName;

    private String lastName;

    @Column(unique = true)
    private String userName;

    @Column(unique = true)
    private String email;

    @JsonIgnore
    @OneToMany(mappedBy = "sender", cascade = CascadeType.REMOVE)
    private List<Marios> givenMarios;

    @JsonIgnore
    @OneToMany(mappedBy = "receiver", cascade = CascadeType.REMOVE)
    private List<Marios> receivedMarios;


    public User(String firstName, String lastName, String userName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.email = email;
        this.givenMarios = new ArrayList<>();
        this.receivedMarios = new ArrayList<>();
    }

    public User() {

    }

    public void addGivenMarios(Marios marios) {
        this.givenMarios.add(marios);
    }

    public void addReceivedMarios(Marios marios) {
        this.receivedMarios.add(marios);
    }

    @Override
    public String toString() {
        return this.firstName.toUpperCase() + " " + this.lastName.toUpperCase();
    }


}
