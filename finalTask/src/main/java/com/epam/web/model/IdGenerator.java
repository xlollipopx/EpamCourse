package com.epam.web.model;

public class IdGenerator {

    private int id = 1;

    public IdGenerator() {}

    public int generateId() {
        return id++;
    }


}
