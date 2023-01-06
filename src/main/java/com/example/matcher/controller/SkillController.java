package com.example.matcher.controller;

import com.example.matcher.entity.Candidate;
import com.example.matcher.entity.Skill;
import com.example.matcher.repository.SkillRepository;
import com.example.matcher.service.CandidateServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SkillController {

    @Autowired
    private CandidateServiceImp candidateServiceImp;

    @Autowired
    private SkillRepository skillRepository;


   @PostMapping("/add/skill")
    public void  addSkill(@RequestBody Skill skill){
       skillRepository.save(skill);
    }

    @PutMapping("/{candidateId}/skill/{skillId}")
    public Candidate assingnedSkillToCandidate(
            @PathVariable String candidateId,
            @PathVariable String skillId)  {

        return candidateServiceImp.assingnedSkillToCandidates(Long.parseLong(candidateId),Long.parseLong(skillId));

    }

}
