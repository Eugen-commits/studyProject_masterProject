package com.example.master_study.controller;

import com.example.master_study.persistance.entity.Work;
import com.example.master_study.service.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping ("/work")
public class WorkController {
    private WorkService workService;

    @Autowired
    public WorkController(WorkService workService) {
        this.workService = workService;
    }

    @GetMapping ("/{id}")
    public ResponseEntity <Work> getWorkById (@PathVariable (value = "id") Long id){
        return new ResponseEntity<>(workService.getWorkById(id), HttpStatus.OK);
    }

    @GetMapping ("/name/{name}")
    public ResponseEntity <Work> getWorkById (@PathVariable (value = "name") String name){
        return new ResponseEntity<>(workService.getWorkByName(name), HttpStatus.OK);
    }

    @GetMapping ("/all")
    public ResponseEntity<Set<Work>> getAllWorks (){
        return new ResponseEntity<>(workService.getAllWorks(), HttpStatus.OK);
    }
}
