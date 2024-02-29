package com.kavin.q1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kavin.q1.model.User;
import com.kavin.q1.repository.UserRepo;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public User post(User p) {
        return userRepo.save(p);
    }

    public User get(int usereId) {
        return userRepo.findRecipeId(usereId);
    }

    public List<User> getName(String userName) {
        return userRepo.findRecipeName(userName);
    }
}
