package com.example.master_study.persistance.repository;

import com.example.master_study.persistance.entity.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Long> {
    Address findAddressByAddressLine (String name);
}
