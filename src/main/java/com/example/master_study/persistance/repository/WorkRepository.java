package com.example.master_study.persistance.repository;

import com.example.master_study.persistance.entity.Work;
import org.springframework.data.repository.CrudRepository;

public interface WorkRepository extends CrudRepository<Work, Long> {
    Work getWorkByName (String name);
}
