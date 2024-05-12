package com.icode.service;

import com.icode.dto.RoleDTO;
import com.icode.dto.UserDTO;
import com.icode.entity.Role;
import org.springframework.stereotype.Service;

import java.util.List;


public interface RoleService {

    List<RoleDTO> listOfAllRoles();

    RoleDTO fineById(Long id);


}
