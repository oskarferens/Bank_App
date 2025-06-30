package com.bankapp.service;

import com.bankapp.dto.UserDto;
import java.util.List;

public interface UserService {
    UserDto findByUsername(String username);

    List<UserDto> findAll();

    UserDto save(UserDto userDto);
}