package com.icode.service.impl;

import com.icode.dto.RoleDTO;
import com.icode.entity.Role;
import com.icode.repository.RoleRepository;
import com.icode.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<RoleDTO> listOfAllRoles() {
        List<Role> roleList = roleRepository.findAll();
        return null;
    }

    @Override
    public RoleDTO fineById(Long id) {
        return null;
    }

}
