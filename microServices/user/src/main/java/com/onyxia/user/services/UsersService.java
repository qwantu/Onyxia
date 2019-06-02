package com.onyxia.user.services;

import com.onyxia.user.dao.UsersRepository;
import com.onyxia.user.entities.Users;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UsersService {

    UsersRepository usersRepository;

    public UsersService(UsersRepository usersRepository){
        this.usersRepository = usersRepository;
    }


    public Users checkSaveAction(Users user){
        return usersRepository.save(user);
    }
}
