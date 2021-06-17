package com.example.master_study.controller;

import com.example.master_study.persistance.entity.Skill;
import com.example.master_study.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping ("/skill")
public class SkillController {
    private SkillService skillService;

    @Autowired
    public SkillController(SkillService skillService) {
        this.skillService = skillService;
    }

    @GetMapping ("/{id}")
    public ResponseEntity <Skill> getById (@PathVariable (value = "id") Long id){
        return new ResponseEntity<>(skillService.get(id), HttpStatus.OK);
    }
    @GetMapping ("/{name}")
    public ResponseEntity <Skill> getByName (@PathVariable (value = "name") String name){
        return new ResponseEntity<>(skillService.get(name), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity <Set<Skill>> getAllSkill(){
        return new ResponseEntity<>(skillService.getAllSkill(),HttpStatus.OK);
    }
}
