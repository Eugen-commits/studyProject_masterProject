package com.example.master_study.service;

import com.example.master_study.persistance.entity.Address;
import com.example.master_study.persistance.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    private AddressRepository addressRepository;

    @Autowired
    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public Address get (Long id){
        return addressRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    public Address get (String name){
        return addressRepository.findAddressByAddressLine(name);
    }

}
