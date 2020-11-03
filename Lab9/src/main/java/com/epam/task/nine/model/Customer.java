package com.epam.task.nine.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;

public class Customer implements Runnable{
    private String name;
    private  List<OrderType> orderList;
    private final Restaurant restaurant;
    private static final int MAX_WAITING_TIME = 10000;
    private boolean beingServed = false;

    public Customer(String name, List<OrderType> orderList) {
        this.name = name;
        this.orderList = new ArrayList<OrderType>(orderList);
        restaurant = Restaurant.getInstance();
    }

    public String getName() {
        return name;
    }

    public List<OrderType> getOrderList() {
        return orderList;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOrderList(List<OrderType> orderList) {
        this.orderList = orderList;
    }

    @Override
    public void run() {
        CashBox cashBox = null;
        try {
            cashBox = restaurant.getCashBox(MAX_WAITING_TIME);
        } catch (ResourceException e) {
            e.printStackTrace();
        } finally {
            if(cashBox != null) {
                beingServed = false;
            }
        }
        beingServed = true;
        if (cashBox != null) {
            cashBox.process(this);
        }

    }

    public boolean isBeingServed() {
            return beingServed;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", orderList=" + orderList +
                '}';
    }

}
