package com.example.matcher.repository;

import com.example.matcher.entity.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CandidateRepository extends JpaRepository<Candidate, Long> {

    Candidate findByCandidateId(Long candidateId);
}
