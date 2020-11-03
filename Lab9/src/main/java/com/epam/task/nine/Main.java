package com.epam.task.nine;

import com.epam.task.nine.data.DataException;
import com.epam.task.nine.data.DataReader;
import com.epam.task.nine.data.FileDataReader;
import com.epam.task.nine.data.JsonCustomerCreator;
import com.epam.task.nine.model.Customer;
import com.epam.task.nine.model.Restaurant;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.javaws.IconUtil;

import java.io.File;
import java.io.IOException;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws DataException {

        FileDataReader reader = new FileDataReader();
        String data = reader.read("input.json");

        Restaurant restaurant = Restaurant.getInstance();
        JsonCustomerCreator creator = new JsonCustomerCreator();
        List<Customer> customers = creator.createCustomers(data);
        System.out.println(customers);
        int amount = customers.size();
        ExecutorService service = Executors.newFixedThreadPool(amount);
        customers.forEach(service::execute);
        service.shutdown();
    }
}
