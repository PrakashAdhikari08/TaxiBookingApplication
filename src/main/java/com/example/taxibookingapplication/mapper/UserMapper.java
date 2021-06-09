package com.example.taxibookingapplication.mapper;

import com.example.taxibookingapplication.domain.Gender;
import com.example.taxibookingapplication.domain.Role;
import com.example.taxibookingapplication.domain.User;
import com.example.taxibookingapplication.dto.UserDto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class UserMapper {

    public static UserDto toDto(User user){
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setEmail(user.getEmail());
//        userDto.setAddress(user.getAddress());
//        userDto.setRole(String.valueOf(user.getRole()));
//        userDto.setGender(String.valueOf(user.getGender()));
//        userDto.setBirthDate(String.valueOf(user.getBirthDate()));
        return userDto;

    }

    public static User toEntity(UserDto userDto){
        User user = new User();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
//        user.setBirthDate(LocalDate.parse(userDto.getBirthDate()));
//        user.setGender(Gender.valueOf(userDto.getGender()));
//        user.setAddress(userDto.getAddress());

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
