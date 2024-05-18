package com.icode.entity;

import com.icode.enums.Gender;
import lombok.*;
import org.hibernate.annotations.Where;
import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "users")
@Where(clause = "is_deleted=false")
public class User extends BaseEntity {

    private String firstName;

    private String lastName;

    private String userName;

    private String passWord;

    private boolean enabled;

    private String phone;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id")
    private Role role;

    @Enumerated(EnumType.STRING)
    private Gender gender;

}
