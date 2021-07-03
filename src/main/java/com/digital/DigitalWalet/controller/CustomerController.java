package com.digital.DigitalWalet.controller;

import com.digital.DigitalWalet.entity.Customers;
import com.digital.DigitalWalet.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    CustomerService customerService;
    @GetMapping("/gatAll")
    public ResponseEntity<List<Customers>> getUser(){
        return new ResponseEntity<>(customerService.getAll(), HttpStatus.OK);
    }
    @GetMapping("/user/{id}")
    public ResponseEntity<Customers> getUserById(@PathVariable Integer id){
        return new ResponseEntity<>(customerService.getById(id), HttpStatus.OK);
    }
    @PostMapping("/adduser")
    public ResponseEntity<Customers> addUser(@RequestBody Customers customers){
        return new ResponseEntity<>(customerService.addCustomer(customers),HttpStatus.CREATED);
    }
}
