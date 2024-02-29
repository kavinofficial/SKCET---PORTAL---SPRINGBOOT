package com.kavin.q1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.kavin.q1.model.Door;
import com.kavin.q1.service.DoorService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api")
public class DoorController {
    @Autowired
    private DoorService doorService;

    @PostMapping("/door")
    public ResponseEntity<Door> postMethodName(@RequestBody Door entity) {
        Door person = doorService.postPerson(entity);
        if (person != null) {
            return new ResponseEntity<>(person, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(person, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/door")
    public ResponseEntity<List<Door>> getMethod() {
        List<Door> list = doorService.getPerson();
        if (list.size() > 0) {
            return new ResponseEntity<>(list, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/door/{doorId}")
    public ResponseEntity<List<Door>> getMethodAge(@PathVariable("doorId") int doorId) {
        List<Door> list = doorService.getDoorById(doorId);
        if (list.size() > 0) {
            return new ResponseEntity<>(list, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/door/accesstype/{accesstype}")
    public ResponseEntity<List<Door>> getMethodAccess(@PathVariable("accesstype") String accesstype) {
        List<Door> list = doorService.getDoorAccess(accesstype);
        if (list.size() > 0) {
            return new ResponseEntity<>(list, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}