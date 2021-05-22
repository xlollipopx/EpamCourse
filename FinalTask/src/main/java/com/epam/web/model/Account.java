package com.epam.web.model;

import java.io.Serializable;

public class Account implements Serializable {

    private int id;
    private String name;
    private String password;
    private double balance;
    private Role role;

    public Account(int id, String name, String password, int role) {
        this.id = id;
        this.name = name;
        this.password = password;
        if(role == 2) {
            this.role = Role.ADMINISTRATOR;
        } else {
            this.role = Role.CUSTOMER;
        }
    }

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public Role getRole() {
        return role;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String toString() {
        return name;
    }

    public double getBalance() {
        return balance;
    }
}
