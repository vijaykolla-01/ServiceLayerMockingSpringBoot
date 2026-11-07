package com.example.demo.service;

import org.springframework.stereotype.Service;
import com.example.demo.model.User;

@Service
public class UserService {

    // Simple demonstration implementation.
    // In the controller unit test, this bean is replaced by a Mockito mock.
    public User getUserById(int id) {
        return new User(id, "Vijay");
    }
}
