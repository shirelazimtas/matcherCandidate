package com.example.matcher.service;

import com.example.matcher.entity.Candidate;
import com.example.matcher.entity.Job;
import com.example.matcher.entity.Skill;
import com.example.matcher.interfaceSrevice.MatchService;
import com.example.matcher.repository.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;


@Service
public class MatchServiceImp extends Candidate implements MatchService {

    @Autowired
    private CandidateRepository candidateRepository;


    @Override
    public List<Candidate> candidateFinder(Job job) {
        String[] jobTitle = job.getTitle().toLowerCase().split(" ");
        String jobSkill = job.getSkill().toLowerCase();
        List<Candidate> candidateList = candidateRepository.findAll();


        List<Candidate> candidatesSuitibale = candidateList.stream().filter(candidate -> isTheTitleMatch(jobTitle, candidate))
                .filter(candidate -> isSkillCandidateMatch(candidate.getAssignedSkill(), jobSkill))
                .sorted(Comparator.comparingInt(Candidate::getWorkExperience).reversed())
                .collect(Collectors.toList());


        List<Candidate> candidatesSuitibaleWithoutSkill = candidateList.stream().filter(candidate -> isTheTitleMatch(jobTitle, candidate))
                .filter(candidate -> (!isSkillCandidateMatch(candidate.getAssignedSkill(), jobSkill)))
                .collect(Collectors.toList());

        candidatesSuitibaleWithoutSkill = sortByAmountOfSkill(candidatesSuitibaleWithoutSkill);


        for (Candidate candidate : candidatesSuitibaleWithoutSkill) {
            candidatesSuitibale.add(candidate);
        }

        return candidatesSuitibale;
    }

    @Override
    public List<Candidate> sortByAmountOfSkill(List<Candidate> candidatesSuitibale) {
        Map<Candidate, Integer> candidateMap = new HashMap<>();
        List<Candidate> candidatesSortSkillByAmountList = new ArrayList<>();
        LinkedHashMap<Candidate, Integer> reverseSortedMap = new LinkedHashMap<>();
        for (int i = 0; i < candidatesSuitibale.size(); i++) {
            candidateMap.putIfAbsent(candidatesSuitibale.get(i), candidatesSuitibale.get(i).getAssignedSkill().size());
        }
        candidateMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(x -> reverseSortedMap.put(x.getKey(), x.getValue()));

        List<Map.Entry<Candidate, Integer>> mapSortByAmountSkill = new ArrayList<>(reverseSortedMap.entrySet());
        for (int i = 0; i < mapSortByAmountSkill.size(); i++) {
            candidatesSortSkillByAmountList.add(i, mapSortByAmountSkill.get(i).getKey());
        }
        return candidatesSortSkillByAmountList;
    }

    @Override
    public boolean isTheTitleMatch(String[] jobTitle, Candidate candidate) {
        String[] arrayCandidateTitle = candidate.getTitle().toLowerCase().split(" ");
        for (int i = 0; i < jobTitle.length; i++) {
            for (int j = 0; j < arrayCandidateTitle.length; j++) {
                if (jobTitle[i].equals(arrayCandidateTitle[j])) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean isSkillCandidateMatch(Set<Skill> candidateSkill, String jodSkill) {
        int size = candidateSkill.size();
        String[] listSkill = new String[size];
        int j = 0;
        for (Skill skill : candidateSkill) {
            listSkill[j] = skill.getSkillName().toLowerCase();
            j++;
        }
        for (int i = 0; i < size; i++) {
            if (listSkill[i].equals(jodSkill.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

}
