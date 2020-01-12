package com.adminOfficialWeb.demo.controller;

import com.adminOfficialWeb.demo.dto.Response;
import com.adminOfficialWeb.demo.dto.UserCategoryDTO;
import com.adminOfficialWeb.demo.service.UserCategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user-categories")
public class UserCategoryController {

    @Autowired
    private UserCategoryServiceImpl userCategoryService;

    @GetMapping("/all")
    public Response getAllCategory(){
        return Response.builder()
                .httpStatus(HttpStatus.OK.value())
                .data(userCategoryService.findAll())
                .build();
    }

    @GetMapping("/active")
    public Response getActiveCategory(){
        return Response.builder()
                .httpStatus(HttpStatus.OK.value())
                .data(userCategoryService.getByActive())
                .build();
    }

    @PostMapping()
    public Response createUserCategory(@RequestBody UserCategoryDTO userCategoryDTO){
        return Response.builder()
                .data(userCategoryService.create(userCategoryDTO))
                .httpStatus(HttpStatus.OK.value())
                .build();
    }

    @PutMapping()
    public Response updateUserCategory(@RequestBody UserCategoryDTO userCategoryDTO){
        return Response.builder()
                .data(userCategoryService.update(userCategoryDTO))
                .httpStatus(HttpStatus.OK.value())
                .build();
    }

    @DeleteMapping(path = "/{id}")
    public Response deleteUserCategoryById(@PathVariable("id") Long id){
        return Response.builder()
                .data(userCategoryService.deleteById(id))
                .httpStatus(HttpStatus.OK.value())
                .build();
    }

}
