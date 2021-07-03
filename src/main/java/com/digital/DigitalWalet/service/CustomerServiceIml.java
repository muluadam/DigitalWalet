package com.digital.DigitalWalet.service;

import com.digital.DigitalWalet.entity.Customers;
import com.digital.DigitalWalet.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceIml implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Customers getById(Integer id) {
        return customerRepository.findById(id).get();
    }

    @Override
    public Customers addCustomer(Customers customers) {
        return customerRepository.save(customers);
    }

    @Override
    public List<Customers> getAll() {
        return customerRepository.findAll();
    }


}
