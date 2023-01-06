package com.example.matcher.controller;

import com.example.matcher.entity.Job;
import com.example.matcher.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JobController {

    @Autowired
    private JobRepository jobRepository;

    @PostMapping("/add/job")
    public void addJob(@RequestBody Job job) {
        jobRepository.save(job);
    }
}
