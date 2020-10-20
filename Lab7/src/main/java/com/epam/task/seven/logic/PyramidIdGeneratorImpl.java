package com.epam.task.seven.logic;

public class PyramidIdGeneratorImpl implements PyramidIdGenerator{
    private int id = 0;

    @Override
    public int generate() {
        return id++;
    }
}
