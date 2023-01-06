package com.example.matcher;

import com.example.matcher.entity.Candidate;
import com.example.matcher.entity.Skill;
import com.example.matcher.repository.CandidateRepository;
import com.example.matcher.repository.JobRepository;
import com.example.matcher.service.CandidateServiceImp;
import com.example.matcher.service.MatchServiceImp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


import static org.junit.Assert.*;

@SpringBootTest
class MatcherApplicationTests {

    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private CandidateServiceImp candidateServiceImp;
    @Autowired
    private MatchServiceImp matchServiceImp;

    @Autowired
    private JobRepository jobRepository;


    @Test
    void isSkillCandidateMatchTest() {
        String jodSkill = "php";
        Set<Skill> candidateSkill = new HashSet<>();
        Skill skillPhp = new Skill(7l, "php", null);
        Skill skillJavaScript = new Skill(7l, "java script", null);
        candidateSkill.add(skillPhp);
        assertTrue(matchServiceImp.isSkillCandidateMatch(candidateSkill, jodSkill));
    }


    @Test
    void isTheTitleMatchTest() {
        String jobTitle = "human resources professional";
        String[] jobTitleSplit = jobTitle.toLowerCase().split(" ");
        Candidate candidate = new Candidate(112l, "shy", null, "human resources", 2);
        assertTrue(matchServiceImp.isTheTitleMatch(jobTitleSplit, candidate));
    }


    @Test
    void sortByAmountOfSkillTest() {
        Set<Skill> candidateSkillCandidate1 = new HashSet<>();
        Set<Skill> candidateSkillCandidate2 = new HashSet<>();
        Skill skillPhp = new Skill(7l, "php", null);
        Skill skillJava = new Skill(8l, "java", null);

        candidateSkillCandidate1.add(skillPhp);
        candidateSkillCandidate2.add(skillJava);
        candidateSkillCandidate2.add(skillPhp);

        Candidate candidate1 = new Candidate(112l, "shy", candidateSkillCandidate1, "human resources", 2);
        Candidate candidate2 = new Candidate(113l, "shalom", candidateSkillCandidate2, "human resources", 2);
        List<Candidate> candidatesSuitibale = new ArrayList<>();
        candidatesSuitibale.add(candidate1);
        candidatesSuitibale.add(candidate2);
        List<Candidate> candidates = matchServiceImp.sortByAmountOfSkill(candidatesSuitibale);
        assertEquals(candidates.get(0).getCandidateName(), "shalom");
        assertEquals(candidates.get(1).getCandidateName(), "shy");

    }


}
