package com.example.matcher.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;


import java.util.HashSet;
import java.util.Set;



@Entity
@Table(name = "skill")
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SkillId", nullable = true)
    private Long skillId;

    public String skillName;

    @JsonIgnore
    @ManyToMany(mappedBy = "assignedSkill")
    public Set<Candidate> assignedCandidate = new HashSet<>();

    public Skill(Long skillId, String skillName, Set<Candidate> assignedCandidate) {
        this.skillId = skillId;
        this.skillName = skillName;
        this.assignedCandidate = assignedCandidate;
    }


    public Skill() {
    }


    public Long getSkillId() {
        return skillId;
    }

    public void setSkillId(Long skillId) {
        this.skillId = skillId;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public Set<Candidate> getAssignedCandidate() {
        return assignedCandidate;
    }

    public void setAssignedCandidate(Set<Candidate> assignedCandidate) {
        this.assignedCandidate = assignedCandidate;
    }
}
