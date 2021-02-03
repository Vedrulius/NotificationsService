package com.mihey.notification.model;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Setter
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "notifications")
public class Notification {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "message")
    private String message;
    @Column(name = "message_id")
    private String messageId;
    @Column(name = "created_by")
    private String createdBy;
    @Column(name = "modified_by")
    private String modifiedBy;
    @Column(name = "created")
    private Timestamp created;
    @Column(name = "modified")
    private Timestamp modified;
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;
    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private Type type;

//    public Notification() {
//    }

//    public Notification(String message, String createdBy, String modifiedBy, Timestamp created, Timestamp modified, Status status, Type type) {
//        this.message = message;
//        this.createdBy = createdBy;
//        this.modifiedBy = modifiedBy;
//        this.created = created;
//        this.modified = modified;
//        this.status = status;
//        this.type = type;
//    }
}


