package com.example.matcher.repository;

import com.example.matcher.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job,Integer> {
    Job findByJobId(int jobId);

}
