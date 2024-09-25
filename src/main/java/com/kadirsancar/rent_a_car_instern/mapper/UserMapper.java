
package com.kadirsancar.rent_a_car_instern.mapper;

import com.kadirsancar.rent_a_car_instern.dto.UserDto;
import com.kadirsancar.rent_a_car_instern.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserDto toDto(User user) {
        if (user == null) {
            return null;
        }
        UserDto dto = new UserDto();
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        // Diğer gerekli alanları ayarla
        return dto;
    }

    public User toEntity(UserDto dto) {
        if (dto == null) {
            return null;
        }
        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        // Diğer gerekli alanları ayarla
        return user;
    }
}
