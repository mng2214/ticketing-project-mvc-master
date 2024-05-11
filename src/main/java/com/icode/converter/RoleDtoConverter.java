//package com.icode.converter;
//
//import com.icode.dto.RoleDTO;
//import com.icode.service.RoleService;
//import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
//import org.springframework.core.convert.converter.Converter;
//import org.springframework.stereotype.Component;
//
//@Component
//@ConfigurationPropertiesBinding
//class RoleDtoConverter implements Converter<String, RoleDTO> {
//
//    RoleService roleService;
//
//    public RoleDtoConverter(RoleService roleService) {
//        this.roleService = roleService;
//    }
//
//    @Override
//    public RoleDTO convert(String source) {
//        return roleService.findById(Long.parseLong(source));
//    }
//}
