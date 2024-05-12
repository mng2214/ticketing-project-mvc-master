package com.icode.converter;

import com.icode.dto.UserDTO;
import com.icode.service.UserService;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@ConfigurationPropertiesBinding
public class UserDtoConverter implements Converter<String, UserDTO> {
    UserService userService;

    public UserDtoConverter(UserService userService) {

        this.userService = userService;
    }

    @Override
    public UserDTO convert(String source) {

        return userService.fineByUserName(source);
    }
}
