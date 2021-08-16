package com.example.userservice.controller;

import com.example.userservice.dto.UserDto;
import com.example.userservice.service.UserService;
import com.example.userservice.vo.Greeting;
import com.example.userservice.vo.RequestUser;
import com.example.userservice.vo.ResponseUser;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class UserController {

    private final Greeting greeting;
    // private final Environment environment;
    private final UserService userService;
    private final ModelMapper modelMapper;

    @GetMapping("/health-check")
    public String status() {
        return "It's working in user-service";
    }

    @GetMapping("/welcome")
    public String welcome() {
        return greeting.getMessage();
        // return environment.getProperty("greeting.message");
    }

    @PostMapping("/users")
    public ResponseEntity<ResponseUser> createUser(@RequestBody RequestUser user) {

        UserDto userDto = userService.createUser(modelMapper.map(user, UserDto.class));

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(modelMapper.map(userDto, ResponseUser.class));
    }
}
