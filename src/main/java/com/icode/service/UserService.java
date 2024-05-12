package com.icode.service;

import com.icode.dto.UserDTO;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {

    List<UserDTO> listOfAllUsers();

    UserDTO fineByUserName(String username);

    void saveUser(UserDTO userDTO);

    UserDTO update(UserDTO userDTO);

    void deleteByUserName(String username);

}
