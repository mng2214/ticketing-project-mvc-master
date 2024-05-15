package com.icode.converter;

import com.icode.dto.RoleDTO;
import com.icode.service.RoleService;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@ConfigurationPropertiesBinding
class RoleDtoConverter implements Converter<String, RoleDTO> {
    RoleService roleService;

    //injection
    public RoleDtoConverter(@Lazy RoleService roleService) {

        this.roleService = roleService;
    }

    @Override
    public RoleDTO convert(String source) {
        if (source.isEmpty()) {
            return null;
        }
        return roleService.fineById(Long.parseLong(source));
    }
}
