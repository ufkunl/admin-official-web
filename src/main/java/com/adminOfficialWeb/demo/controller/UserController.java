package com.adminOfficialWeb.demo.controller;

import com.adminOfficialWeb.demo.dto.Response;
import com.adminOfficialWeb.demo.dto.UserDTO;
import com.adminOfficialWeb.demo.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserServiceImpl userService;

    @Autowired
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public Response getAllUser(){
        return Response.builder()
                .httpStatus(HttpStatus.OK.value())
                .data(userService.findAll())
                .build();
    }

    @GetMapping("/active")
    public Response getActiveUser(){
        return Response.builder()
                .httpStatus(HttpStatus.OK.value())
                .data(userService.getByActive())
                .build();
    }

    @PostMapping
    public Response createUser(@RequestBody UserDTO userDTO){
        return Response.builder()
                .data(userService.create(userDTO))
                .httpStatus(HttpStatus.OK.value())
                .build();
    }

    @PutMapping
    public Response updateUser(@RequestBody UserDTO userDTO){
        return Response.builder()
                .data(userService.update(userDTO))
                .httpStatus(HttpStatus.OK.value())
                .build();
    }

    @DeleteMapping(path = "/{id}")
    public Response deleteUserById(@PathVariable("id") Long id){
        return Response.builder()
                .data(userService.deleteById(id))
                .httpStatus(HttpStatus.OK.value())
                .build();
    }

}
