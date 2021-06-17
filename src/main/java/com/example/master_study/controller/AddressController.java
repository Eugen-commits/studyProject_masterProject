package com.example.master_study.controller;

import com.example.master_study.persistance.entity.Address;
import com.example.master_study.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/addresses")
public class AddressController {
    private AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping ("/{id}")
    public ResponseEntity <Address> getById (@PathVariable (value = "id") Long id){
        return new ResponseEntity<>(addressService.get(id), HttpStatus.OK);
    }

    @GetMapping ("/{address}")
    public ResponseEntity <Address> getByAddressName (@PathVariable (value = "address") String name){
        return new ResponseEntity<>(addressService.get(name), HttpStatus.OK);
    }

}
