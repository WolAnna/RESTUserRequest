package com.example.UserRequest.REST.controller;

import com.example.UserRequest.REST.modelREST.RestUserDTO;
import com.example.UserRequest.service.UserRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserRequestController {
    @Autowired
    private UserRequestService userRequestService;

    @GetMapping("/users/{login}")
    public RestUserDTO getCountRequestUser(@PathVariable String login){
        return userRequestService.getRestUserByLogin(login);
    }
}
