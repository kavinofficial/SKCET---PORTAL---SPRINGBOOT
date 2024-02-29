package com.kavin.q1.controller;

import org.springframework.web.bind.annotation.RestController;

import com.kavin.q1.model.User;
import com.kavin.q1.service.UserService;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public ResponseEntity<User> postMethodName(@RequestBody User param) {
        User p = userService.post(param);
        if (p != null) {
            return new ResponseEntity<>(p, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<User> getMethodName(@PathVariable("userId") int userId) {
        User p = userService.get(userId);
        if (p != null) {
            return new ResponseEntity<>(p, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/user/byname/{userName}")
    public ResponseEntity<List<User>> getMethodName(@PathVariable("userName") String userName) {
        List<User> list = userService.getName(userName);
        if (!list.isEmpty()) {
            return new ResponseEntity<>(list, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}
