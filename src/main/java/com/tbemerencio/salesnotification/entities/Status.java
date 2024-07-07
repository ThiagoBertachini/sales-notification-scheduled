package com.tbemerencio.salesnotification.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity @Table(name = "tb_status")
public class Status {

    @Id
    private Long id;
    private String description;

    public Status() {
    }

    public Status(Long id, String description) {
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

    public enum StatusEnums{
        PENDING(1L, "pendding"),
        SUCCESS(2L, "success"),
        ERROR(3L, "error"),
        CANCELED(4L, "canceled");

        private final Long id;
        private final String description;

        StatusEnums(long id, String description) {
            this.id = id;
            this.description = description;
        }

        public Status toStatus(){
            return new Status(id, description);
        }
    }
}
