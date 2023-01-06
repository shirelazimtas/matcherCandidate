package com.example.matcher.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "candidate")
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "candidateId", nullable = true)
    private Long candidateId;

    @Column(name = "candidateName")
    private String candidateName;

    @ManyToMany
    @JoinTable(name = "candidate_skill",
            joinColumns = @JoinColumn(name = "candidate_id"),
            inverseJoinColumns = @JoinColumn(name = "skill_id")
    )
    public Set<Skill> assignedSkill = new HashSet<>();

    @Column(name = "title")
    private String title;

    @Column(name = "workExperience")
    private int workExperience;

    public Candidate() {
    }

}
