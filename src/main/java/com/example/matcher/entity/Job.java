package com.example.matcher.entity;

import jakarta.persistence.*;



@Entity
@Table(name = "job")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "jobId", nullable = true)
    private int jobId;

    @Column(name = "title")
    private String title;

    @Column(name = "skill")
    private String skill;

    public Job() {
    }

    public Job(int jobId, String title, String skill) {
        this.jobId = jobId;
        this.title = title;
        this.skill = skill;
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }
}
