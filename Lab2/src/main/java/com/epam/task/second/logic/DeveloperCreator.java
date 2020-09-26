package com.epam.task.second.logic;

public class DeveloperCreator {

    public SoftwareDeveloper create(String name, int daysRequired) {
        return new SoftwareDeveloper(name, daysRequired);
    }

}
