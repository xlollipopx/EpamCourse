package com.epam.task.nine.model;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class CashBox {
    private static final ReentrantLock LOCK = new ReentrantLock();

    public CashBox() {
    }

    public void process(Customer customer) {
            int time = countOrderTime(customer.getOrderList());
        try {
            TimeUnit.MILLISECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private int countOrderTime(List<OrderType> orders) {
        int result = 0;
        for (OrderType order : orders) {
            if(order == OrderType.BURGER) {
                result += TimingMenu.getBurgerTime();
            } else if(order == OrderType.POTATO) {
                result += TimingMenu.getPotatoTime();
            } else if(order == OrderType.COFFEE) {
                result += TimingMenu.getCoffeeTime();
            } else if(order == OrderType.TEA) {
                result += TimingMenu.getTeaTime();
            } else if(order == OrderType.BEEF) {
                result += TimingMenu.getBeefTime();
            }
        }
        return result;
    }

    private int compareBoolean(boolean x, boolean y) {
        int a, b;
        if(x) {
            a = 0;
            b = 1;
        }
        else{
            a = 1;
            b = 0;
        }
        return a - b;
    }

}
