package com.epam.task.nine.data;

import com.epam.task.nine.model.Customer;
import com.epam.task.nine.model.OrderType;
import com.epam.task.nine.model.Restaurant;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JsonCustomerCreator {
    private static final String CUSTOMERS = "customers";
    private static final String NAME = "name";
    private static final String ORDER = "order";

    public JsonCustomerCreator(){
    }

    public List<Customer> createCustomers(String data) {
        JSONObject shipsObject = new JSONObject(data);
        JSONArray customerArray = shipsObject.getJSONArray(CUSTOMERS);
        List<Customer> customers = new ArrayList<>();
        for (int i = 0; i < customerArray.length(); i++) {
            JSONObject customerObject = customerArray.getJSONObject(i);
            Customer customer = createCustomer(customerObject);
            customers.add(customer);
        }
        return customers;
    }

    private Customer createCustomer(JSONObject customerObject) {
        String name = customerObject.getString(NAME);
        JSONArray orders = customerObject.getJSONArray(ORDER);
        List<OrderType> orderTypes = new ArrayList<OrderType>();
        for(int i = 0; i < orders.length(); i++) {
            orderTypes.add(orders.getEnum(OrderType.class, i));
        }
        return new Customer(name, orderTypes);
    }
}
