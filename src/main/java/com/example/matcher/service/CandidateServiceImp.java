package com.example.matcher.service;

import com.example.matcher.entity.Candidate;
import com.example.matcher.entity.Skill;
import com.example.matcher.interfaceSrevice.CandidateService;
import com.example.matcher.repository.CandidateRepository;
import com.example.matcher.repository.SkillRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;


@Service
public class CandidateServiceImp implements CandidateService {

    @Autowired
    private SkillRepository skillRepository;

    @Autowired
    private CandidateRepository candidateRepository;

    private static final Logger logger = LoggerFactory.getLogger(CandidateServiceImp.class);

    @Override
    public Candidate assingnedSkillToCandidates(Long candidateId, Long skillId) {
        Candidate candidate = candidateRepository.findByCandidateId(candidateId);
        try {
            Set<Skill> skillSet = null;
            Skill skill = skillRepository.findBySkillId(skillId);
            skillSet = candidate.getAssignedSkill();
            skillSet.add(skill);
            candidate.setAssignedSkill(skillSet);
            candidateRepository.save(candidate);
        } catch (Exception exception) {
            logger.warn("the exception was throw " + exception.getMessage(), exception);
        }
        return candidate;
    }
}
