package com.deloitte.ads.marios.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class UserDTO {
    private String firstName;
    private String lastName;
    private UUID uuid;
    private String email;
    private String userName;

    public UserDTO(String firstName, String lastName, UUID uuid, String email, String userName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.uuid = uuid;
        this.email = email;
        this.userName = userName;
    }

}
