package com.cydeo.entity;

import com.cydeo.dto.RoleDTO;
import com.cydeo.enums.Gender;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class User extends BaseEntity {

    private String firstname;
    private String lastname;
    private String username;
    private String password;
    private boolean enabled;
    private String phone;
    private RoleDTO role;
    private Gender gender;

    public User(Long id, LocalDateTime insertDateTime, Long insertUserId, LocalDateTime lastUpdateDateTime, Long lastUpdateUserId, String firstname, String lastname, String username, String password, boolean enabled, String phone, RoleDTO role, Gender gender) {
        super(id, insertDateTime, insertUserId, lastUpdateDateTime, lastUpdateUserId);
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.phone = phone;
        this.role = role;
        this.gender = gender;
    }
}
