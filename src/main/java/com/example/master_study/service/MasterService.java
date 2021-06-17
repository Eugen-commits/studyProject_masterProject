package com.example.master_study.service;

import com.example.master_study.persistance.entity.Master;
import com.example.master_study.persistance.repository.MasterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class MasterService {
    private MasterRepository masterRepository;

    @Autowired
    public MasterService(MasterRepository masterRepository) {
        this.masterRepository = masterRepository;
    }

    public Master getMasterById (Long id){
       return masterRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    public Master getMasterByName (String name) {
        return masterRepository.findByNameEquals(name);
    }

    @Transactional
    public void createMaster (Master master){
        List <Master> masters = new ArrayList<>();
        masterRepository.findAll().iterator().forEachRemaining(masters::add);
        for (Master master1 : masters) {
            if (master.equals(master1)) {
                throw new RuntimeException("Добавлен существующий мастер");
            } else masterRepository.save(master);
        }
    }

    public Master getBySkill (String skillName) {
        return masterRepository.findBySkills(skillName);
    }

    public void deleteMasterById (Long id){
        masterRepository.deleteById(id);
    }

    public void delete (Master master){
        masterRepository.delete(master);
    }

    public Set<Master> getAllMasters (){
        Set <Master> masters = new HashSet<>();
        masterRepository.findAll()
                        .iterator()
                        .forEachRemaining(masters::add);
        return masters;
    }
}
