package com.icode.entity;

import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column(updatable = false, nullable = false)
    protected LocalDateTime insertDateTime;

    @Column(updatable = false, nullable = false)
    protected Long insertUserId;

    protected LocalDateTime lastUpdateDateTime;

    protected Long lastUpdateUserId;

    protected Boolean isDeleted = false; // soft delete

}
