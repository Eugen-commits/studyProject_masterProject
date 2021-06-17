package com.example.master_study.controller;

import com.example.master_study.persistance.entity.Master;
import com.example.master_study.persistance.enums.Districts;
import com.example.master_study.service.MasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/masters")
public class MasterController {
    private MasterService masterService;

    @Autowired
    public MasterController(MasterService masterService) {
        this.masterService = masterService;
    }

    @PostMapping ("/create")
    public ResponseEntity<HttpStatus> createMaster (@RequestBody Master master){
        masterService.createMaster(master);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping ("/delete")
    public ResponseEntity <HttpStatus> deleteMaster (@RequestBody Master master){
        masterService.delete(master);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping ("/delete/{id}")
    public ResponseEntity <HttpStatus> deleteMaster (@PathVariable(value = "id") Long id){
        masterService.deleteMasterById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping ("/{id}")
    public ResponseEntity <Master> getById (@PathVariable (value = "id") Long id) {
        return new ResponseEntity<>(masterService.getMasterById(id), HttpStatus.OK);
    }
    @GetMapping ("/name/{name}")
    public ResponseEntity <Master> getByName (@PathVariable (value = "name") String name) {
        return new ResponseEntity<>(masterService.getMasterByName(name), HttpStatus.OK);
    }
    @GetMapping ("/all")
    public ResponseEntity <Set<Master>> getAllMasters (){
        return new ResponseEntity<>(masterService.getAllMasters(),HttpStatus.OK);
    }
}
