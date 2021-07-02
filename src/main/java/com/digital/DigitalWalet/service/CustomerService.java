package com.digital.DigitalWalet.service;

import com.digital.DigitalWalet.entity.Customers;

public interface CustomerService {

    public Customers getById(Integer id);
    public Customers addCustomer(Customers customers);
}
