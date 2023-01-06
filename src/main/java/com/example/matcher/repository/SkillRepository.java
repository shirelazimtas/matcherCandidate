package com.example.matcher.repository;

import com.example.matcher.entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillRepository  extends JpaRepository<Skill,Long> {
    Skill findBySkillId(Long SkillId);

}
