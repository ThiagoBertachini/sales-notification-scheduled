package com.tbemerencio.salesnotification.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity @Table(name = "tb_channels")
public class Channel {

    @Id
    private Long id;
    private String description;

    public Channel() {
    }

    public Channel(Long id, String description) {
        this.id = id;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public enum ChannelEnums{
        EMAIL(1L, "email"),
        SMS(2L, "sms"),
        PUSH(3L, "push"),
        WHATSAPP(4L, "whatsapp");

        private final Long id;
        private final String description;

        ChannelEnums(Long id, String description) {
            this.id = id;
            this.description = description;
        }

        public Channel toChannel(){
            return new Channel(id, description);
        }
    }
}