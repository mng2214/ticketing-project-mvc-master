package com.icode.service;

import com.icode.dto.RoleDTO;
import java.util.List;

public interface RoleService {

    List<RoleDTO> listAllRoles();

    RoleDTO findById(Long id);


}
