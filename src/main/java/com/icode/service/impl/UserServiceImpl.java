package com.icode.service.impl;

import com.icode.dto.UserDTO;
import com.icode.service.UserService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public List<UserDTO> listOfAllUsers() {
        return null;
    }

    @Override
    public UserDTO fineByUserName(String username) {
        return null;
    }

    @Override
    public void saveUser(UserDTO userDTO) {

    }

    @Override
    public UserDTO update(UserDTO userDTO) {
        return null;
    }

    @Override
    public void deleteByUserName(String username) {

    }

}
