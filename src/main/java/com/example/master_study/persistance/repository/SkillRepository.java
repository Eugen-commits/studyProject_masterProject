package com.example.master_study.persistance.repository;

import com.example.master_study.persistance.entity.Skill;
import org.springframework.data.repository.CrudRepository;

public interface SkillRepository extends CrudRepository<Skill, Long> {
    Skill findByNameEquals (String name);
}
