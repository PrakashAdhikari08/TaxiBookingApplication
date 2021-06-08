package com.example.taxibookingapplication.mapper;

import com.example.taxibookingapplication.domain.User;
import com.example.taxibookingapplication.dto.UserDto;

import java.util.ArrayList;
import java.util.List;

public class UserMapper {

    public static UserDto toDto(User user){
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());

        return userDto;

    }

    public static User toEntity(UserDto userDto){
        User user = new User();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());

        return user;
    }

    public static List<UserDto> toDtoList(List<User> users) {
        List<UserDto> dtoList = new ArrayList<>();
        users.forEach(
                (user)-> dtoList.add(toDto(user))
        );
        return dtoList;
    }
}
