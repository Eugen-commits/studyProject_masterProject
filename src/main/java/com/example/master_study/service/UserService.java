package com.example.master_study.service;

import com.example.master_study.persistance.entity.User;
import com.example.master_study.persistance.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService{

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public void create (User user){
        userRepository.save(user);
    }

    public User get (Long id) {
        return userRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    public User get (String userPhone){
        return userRepository.findUserByPhone(userPhone);
    }

    public Set<User> getAllUsers (){
        Set <User> allUsers = new HashSet<>();
        userRepository.findAll().iterator().forEachRemaining(allUsers::add);
        return allUsers;
    }

    public void deleteByPhoneNumb (String phoneNumb) {
        userRepository.deleteUserByPhone(phoneNumb);
   }
}
