package com.example.master_study.service;

import com.example.master_study.persistance.entity.Skill;
import com.example.master_study.persistance.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class SkillService {
    private SkillRepository skillRepository;

    @Autowired
    public SkillService(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }

    public Skill get (Long id) {
      return skillRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    public Skill get (String name) {
        return skillRepository.findByNameEquals(name);
    }

    public Set<Skill> getAllSkill () {
        Set <Skill> skills = new HashSet<>();
        skillRepository.findAll().iterator().forEachRemaining(skills::add);
        return skills;
    }
}
