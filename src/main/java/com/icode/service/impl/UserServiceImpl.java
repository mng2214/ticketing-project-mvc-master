package com.icode.service.impl;

import com.icode.dto.UserDTO;
import com.icode.service.UserService;
import java.util.List;

public class UserServiceImpl implements UserService {

    @Override
    public List<UserDTO> listOfAllUsers() {
        return List.of();
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
