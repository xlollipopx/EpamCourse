package com.epam.task.seven.logic.comparator;

import com.epam.task.seven.model.Pyramid;

import java.util.Comparator;

public class PyramidIdComparator implements Comparator<Pyramid> {
    @Override
    public int compare(Pyramid pyramidOne, Pyramid pyramidTwo) {
        int idOne =  pyramidOne.getId();
        int idTwo = pyramidTwo.getId();
        return idOne - idTwo;
    }
}
