package com.kavin.q2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kavin.q2.model.Job;
import com.kavin.q2.repository.JobRepo;

@Service
public class JobService {
    @Autowired
    public JobRepo jobRepo;

    @SuppressWarnings("null")
    public boolean postJob(Job j) {
        try {
            jobRepo.save(j);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<Job> getJobs() {
        return jobRepo.findAll();
    }

    public Optional<Job> getJobId(int id) {
        return jobRepo.findById(id);
    }
}
