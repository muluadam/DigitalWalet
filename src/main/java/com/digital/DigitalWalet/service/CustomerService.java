package com.digital.DigitalWalet.service;

import com.digital.DigitalWalet.entity.Customers;

import java.util.List;

public interface CustomerService {

    public Customers getById(Integer id);
    public Customers addCustomer(Customers customers);
    public List<Customers> getAll();
}
