package com.example.master_study.service;

import com.example.master_study.persistance.entity.Work;
import com.example.master_study.persistance.repository.WorkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class WorkService {
    private WorkRepository workRepository;

    @Autowired
    public WorkService(WorkRepository workRepository) {
        this.workRepository = workRepository;
    }

    public Work getWorkByName (String name){
        return workRepository.getWorkByName(name);
    }

    public Work getWorkById (Long id){
        return workRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    public Set <Work> getAllWorks (){
        Set <Work> works = new HashSet<>();
        workRepository.findAll().iterator().forEachRemaining(works::add);
        return works;
    }

}
