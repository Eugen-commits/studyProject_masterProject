package com.example.master_study.persistance.repository;

import com.example.master_study.persistance.entity.Master;
import org.springframework.data.repository.CrudRepository;

public interface MasterRepository extends CrudRepository<Master, Long> {
    Master findByNameEquals (String name);
    Master findBySkills(String name);
}
