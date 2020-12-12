package com.epam.web.model;

public class Account {
    private String name;
    private String password;
    private double balance;
    private Role role;

    public Account(String name, String password, int role) {
        this.name = name;
        this.password = password;
        if(role == 1) {
            this.role =Role.ADMINISTRATOR;
        } else {
            this.role = Role.CUSTOMER;
        }
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String toString() {
        return name;
    }

}
