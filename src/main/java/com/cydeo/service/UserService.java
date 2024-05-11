package com.cydeo.service;

import com.cydeo.dto.UserDTO;
import com.cydeo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Service
public interface UserService {

    List<UserDTO> listOfAllUsers();

    UserDTO fineByUserName(String username);

    void saveUser(UserDTO userDTO);

    UserDTO update(UserDTO userDTO);

    void deleteByUserName(String username);

}
