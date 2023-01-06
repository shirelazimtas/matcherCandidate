package com.example.matcher.interfaceSrevice;

import com.example.matcher.entity.Candidate;

public interface CandidateService {

    Candidate assingnedSkillToCandidates(Long candidateId, Long skillId);

}
