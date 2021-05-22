package com.epam.task.nine.data;

import com.epam.task.nine.model.Customer;

import java.util.List;

public interface CustomerCreator {
    List<Customer> createCustomers(String data);
}
