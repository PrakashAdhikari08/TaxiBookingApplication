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

    private String email;

    private String password;



}
