package com.epam.task.seven.logic.comparator;

import com.epam.task.seven.model.Pyramid;

import java.util.Comparator;

public class PyramidSurfaceAreaComparator implements Comparator<Pyramid> {
    @Override
    public int compare(Pyramid pyramidOne, Pyramid pyramidTwo) {
        double areaOne = pyramidOne.getSurfaceArea();
        double areaTwo = pyramidTwo.getSurfaceArea();
        return Double.compare(areaOne,areaTwo);
    }
}
