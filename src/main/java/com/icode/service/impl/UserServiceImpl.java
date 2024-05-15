package com.icode.service.impl;

import com.icode.dto.UserDTO;
import com.icode.entity.User;
import com.icode.mapper.UserMapper;
import com.icode.repository.UserRepository;
import com.icode.service.UserService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        List<User> allUsers = userRepository.findAll(Sort.by("firstname"));
        return allUsers.stream().map(userMapper::toUserDTO).collect(Collectors.toList());
    }

    @Override
    public UserDTO fineByUserName(String username) {
        User byUsername = userRepository.findByUsername(username);
        return userMapper.toUserDTO(byUsername);
    }

    @Override
    public void saveUser(UserDTO userDTO) {
        userRepository.save(userMapper.toUser(userDTO));
    }

    @Override
    public UserDTO update(UserDTO userDTO) {
        User user = userRepository.findByUsername(userDTO.getUsername());
        User converteduser = userMapper.toUser(userDTO);
        converteduser.setId(user.getId());
        userRepository.save(converteduser);
        return userDTO;
    }

    @Override
    public void deleteByUserName(String username) {
        userRepository.deleteByUsername(username);
    }

    @Override
    public void delete(String username) {
        User user = userRepository.findByUsername(username);
        user.setIsDeleted(true);
        userRepository.save(user);
    }

}
