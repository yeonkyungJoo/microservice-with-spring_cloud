package com.example.userservice.service;

import com.example.userservice.dto.UserDto;
import com.example.userservice.repository.UserEntity;

public interface UserService {

    UserDto createUser(UserDto UserDto);

    UserDto getUserByUserId(String userId);

    Iterable<UserEntity> getUserByAll();
}
