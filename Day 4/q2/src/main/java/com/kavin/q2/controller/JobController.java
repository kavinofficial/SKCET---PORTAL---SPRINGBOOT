package com.kavin.q2.controller;

import org.springframework.web.bind.annotation.RestController;

import com.kavin.q2.model.Job;
import com.kavin.q2.service.JobService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api")

public class JobController {
    @Autowired
    public JobService service;

    @PostMapping("/job")
    public ResponseEntity<Job> postMethodName(@RequestBody Job entity) {
        if (service.postJob(entity)) {
            return new ResponseEntity<>(entity, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(entity, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/job")
    public ResponseEntity<List<Job>> getMethodName() {
        List<Job> list = service.getJobs();
        if (list.size() > 0) {
            return new ResponseEntity<>(list, HttpStatus.OK);
        }
        return new ResponseEntity<>(list, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/job/{jobId}")
    public ResponseEntity<Optional<Job>> getMethodName(@PathVariable int jobId) {
        Optional<Job> j = service.getJobId(jobId);
        if (j.isPresent()) {
            return new ResponseEntity<>(j, HttpStatus.OK);
        }
        return new ResponseEntity<>(j, HttpStatus.NOT_FOUND);
    }
}
