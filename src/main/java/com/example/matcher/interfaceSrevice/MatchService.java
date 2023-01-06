package com.example.matcher.interfaceSrevice;

import com.example.matcher.entity.Candidate;
import com.example.matcher.entity.Job;
import com.example.matcher.entity.Skill;

import java.util.List;
import java.util.Set;

public interface MatchService {

    List<Candidate> candidateFinder(Job job);

    List<Candidate> sortByAmountOfSkill(List<Candidate> candidatesSuitibale);

    boolean isTheTitleMatch(String[] jobTitle, Candidate candidate);

    boolean isSkillCandidateMatch(Set<Skill> candidateSkill, String jodSkill);
}
