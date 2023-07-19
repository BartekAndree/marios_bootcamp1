package com.deloitte.ads.marios.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;
@Getter
@Setter
public class PublicUserDTO {
    private UUID uuid;
    private String userName;

    public PublicUserDTO(UUID uuid, String userName) {
        this.uuid = uuid;
        this.userName = userName;
    }
}
