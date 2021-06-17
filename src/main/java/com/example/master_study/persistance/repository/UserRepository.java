package com.example.master_study.persistance.repository;

import com.example.master_study.persistance.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findUserByPhone (String name);
    void deleteUserByPhone (String phoneNumber);
}
