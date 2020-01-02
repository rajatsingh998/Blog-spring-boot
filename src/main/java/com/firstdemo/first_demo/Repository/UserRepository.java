package com.firstdemo.first_demo.Repository;


import com.firstdemo.first_demo.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
        User findByName(String username);
}
