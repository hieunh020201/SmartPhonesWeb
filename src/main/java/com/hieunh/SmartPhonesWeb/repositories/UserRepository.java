package com.hieunh.SmartPhonesWeb.repositories;

import com.hieunh.SmartPhonesWeb.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
    public User findByEmail(String email);
}
