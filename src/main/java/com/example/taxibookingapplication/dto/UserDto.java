package com.example.taxibookingapplication.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private Integer Id;

    private String firstName;

    private String lastName;

    private String address;

    private String birthDate;

    private String lastUpdated;

    private String gender;

    private String role;

    private String email;

    private String password;

    private String resetToken;



}
