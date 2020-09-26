package com.epam.task.second.logic;

public class SoftwareDeveloper {
    private String name;
    private int daysRequired;

    public SoftwareDeveloper(){}

    public SoftwareDeveloper(String name, int daysRequired) {
        this.name = name;
        this.daysRequired = daysRequired;
    }

    public int getDaysRequired() {
        return daysRequired;
    }

    public void setDaysRequired(int daysRequired) {
        this.daysRequired = daysRequired;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "developer: " + name +
                '\n' + "required time: " + daysRequired;
    }
}
