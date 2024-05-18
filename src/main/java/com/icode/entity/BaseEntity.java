package com.icode.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@MappedSuperclass
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(updatable = false, nullable = false)
    private LocalDateTime insertDateTime;

    @Column(updatable = false, nullable = false)
    private Long insertUserId;

    private LocalDateTime lastUpdateDateTime;

    private Long lastUpdateUserId;

    private Boolean isDeleted = false; // soft delete

    @PrePersist
    public void onPrePersist() {
        this.insertDateTime = LocalDateTime.now();
        this.lastUpdateDateTime = LocalDateTime.now();
        this.insertUserId = 1L;
        this.lastUpdateUserId = 1L;
    }

    @PreUpdate
    public void onPreUpdate() {
        this.lastUpdateDateTime = LocalDateTime.now();
        this.lastUpdateUserId = 1L;
    }
}
