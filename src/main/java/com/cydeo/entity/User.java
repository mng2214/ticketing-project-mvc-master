package com.cydeo.entity;

import com.cydeo.enums.Gender;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@NoArgsConstructor
public class User extends BaseEntity {

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String password;
    private String confirmPassword;
    private Gender gender;
    private Role role;
    private boolean enabled;

    public User(Long id, LocalDateTime insertDateTime, Long insertUserId, LocalDateTime lastUpdateDateTime, Long lastUpdateUserId, String firstName, String lastName, String email, String phoneNumber, String password, String confirmPassword, Gender gender, Role role, boolean enabled) {
        super(id, insertDateTime, insertUserId, lastUpdateDateTime, lastUpdateUserId);
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.gender = gender;
        this.role = role;
        this.enabled = enabled;
    }

}
