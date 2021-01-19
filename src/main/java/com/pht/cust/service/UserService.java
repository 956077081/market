package com.pht.cust.service;

import com.pht.cust.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    public User login(User user) {
        return new User();
    }
}
