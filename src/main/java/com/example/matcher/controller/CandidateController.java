package com.example.matcher.controller;

import com.example.matcher.entity.Candidate;
import com.example.matcher.repository.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CandidateController {

    @Autowired
    private CandidateRepository candidateRepository;

    @GetMapping("/get/candidate")
    public List<Candidate> getAllCandidate() {
        return candidateRepository.findAll();
    }

    @GetMapping("/get/candidate/{id}")
    public Candidate getCandidateById(@PathVariable int id) {
        return candidateRepository.findByCandidateId(Long.valueOf(id));
    }

    @PostMapping("/save/candidate")
    public void saveCandidate(@RequestBody Candidate candidate) {
        candidateRepository.save(candidate);
    }

}
