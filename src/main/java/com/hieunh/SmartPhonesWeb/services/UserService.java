package com.hieunh.SmartPhonesWeb.services;

import com.hieunh.SmartPhonesWeb.entities.User;
import com.hieunh.SmartPhonesWeb.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return (List<User>) repository.findAll();
    }


}
