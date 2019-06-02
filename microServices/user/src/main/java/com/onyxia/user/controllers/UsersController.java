package com.onyxia.user.controllers;

import com.onyxia.user.dao.UsersRepository;
import com.onyxia.user.entities.Users;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.onyxia.user.services.UsersService;


@RestController
@RequestMapping("/v1/users")
public class UsersController {

    UsersService usersService;
    UsersRepository usersRepository;

    public UsersController(UsersRepository usersRepository, UsersService usersService){
        this.usersRepository = usersRepository;
        this.usersService = usersService;
    }


    @GetMapping
    @ResponseBody
    public String list(){
        return "USERS list";
    }

    @PostMapping
    public Users create(@Validated @RequestBody Users user){

        return usersService.checkSaveAction(user);
    };

}

