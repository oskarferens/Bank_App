package com.bankapp.dto;

import lombok.Data;

import java.util.Set;

@Data
public class UserDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String pesel;
    private String phoneNumber;
    private String address;
    private String city;
    private Set<String> roles;
}