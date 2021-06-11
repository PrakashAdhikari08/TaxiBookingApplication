package com.example.taxibookingapplication.dto;

import com.example.taxibookingapplication.domain.Gender;
import com.example.taxibookingapplication.domain.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private Integer Id;

    private String firstName;

    private String lastName;

    private String address;

    private LocalDate birthDate;

    private String lastUpdated;

    private Gender gender;

    private Role role;

    private String email;

    private String password;

    private String resetToken;



}
