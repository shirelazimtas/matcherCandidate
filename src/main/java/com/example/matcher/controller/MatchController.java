package com.example.matcher.controller;

import com.example.matcher.entity.Candidate;
import com.example.matcher.repository.JobRepository;
import com.example.matcher.service.MatchServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MatchController {

    @Autowired
    private MatchServiceImp matchServiceImp;

    @Autowired
    private JobRepository jobRepository;


    @GetMapping("/matcher/candidate/{id}")
    public List<Candidate> getAllTheCandidateForSuitJob(@PathVariable int id) {
        List<Candidate> candidatesSuitJob = matchServiceImp.candidateFinder(jobRepository.findByJobId(id));
        return candidatesSuitJob;
    }
}
