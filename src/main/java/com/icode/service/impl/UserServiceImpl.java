package com.icode.service.impl;

import com.icode.dto.UserDTO;
import com.icode.entity.User;
import com.icode.mapper.UserMapper;
import com.icode.repository.UserRepository;
import com.icode.service.UserService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    UserRepository userRepository;
    UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public List<UserDTO> listOfAllUsers() {
        List<User> allUsers = userRepository.findAll();
        return allUsers.stream().map(userMapper::toUserDTO).collect(Collectors.toList());
    }

    @Override
    public UserDTO fineByUserName(String username) {
        return null;
    }

    @Override
    public void saveUser(UserDTO userDTO) {
        userRepository.save(userMapper.toUser(userDTO));
    }

    @Override
    public UserDTO update(UserDTO userDTO) {
        return null;
    }

    @Override
    public void deleteByUserName(String username) {

    }

}
