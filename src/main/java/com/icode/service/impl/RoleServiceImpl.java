package com.icode.service.impl;

import com.icode.dto.RoleDTO;
import com.icode.entity.Role;
import com.icode.mapper.RoleMapper;
import com.icode.repository.RoleRepository;
import com.icode.service.RoleService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;

    public RoleServiceImpl(RoleRepository roleRepository, RoleMapper roleMapper) {
        this.roleRepository = roleRepository;
        this.roleMapper = roleMapper;
    }

    @Override
    public List<RoleDTO> listOfAllRoles() {
        List<Role> roleList = roleRepository.findAll();
        return roleList.stream().map(roleMapper::convertToDto).collect(Collectors.toList());
    }

    @Override
    public RoleDTO fineById(Long id) {
        Optional<Role> byId = roleRepository.findById(id);
        return byId.map(roleMapper::convertToDto).orElse(null);
    }

}
