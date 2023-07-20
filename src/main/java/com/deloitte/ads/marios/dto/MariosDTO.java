package com.deloitte.ads.marios.dto;

import com.deloitte.ads.marios.entity.Marios;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class MariosDTO {
    private UUID mariosId;
    private UUID senderId;
    private UUID receiverId;
    private String type;
    private String comment;
    private LocalDateTime timestamp;

    public MariosDTO(UUID mariosId, UUID senderId, UUID receiverId, String type, String comment, LocalDateTime timestamp) {
        this.mariosId = mariosId;
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.type = type;
        this.comment = comment;
        this.timestamp = timestamp;
    }

    public static MariosDTO mariosEntityToMariosDTO(Marios marios) {
        return new MariosDTO(marios.getUuid()
                , marios.getSender().getUuid()
                , marios.getReceiver().getUuid()
                , marios.getType()
                , marios.getComment(), marios.getTimestamp());
    }
}
