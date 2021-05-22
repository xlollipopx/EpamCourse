package com.epam.task.seven.logic.comparator;

import com.epam.task.seven.model.Point;
import com.epam.task.seven.model.Pyramid;

import java.util.Comparator;

public class PyramidFirstPointXComparator implements Comparator<Pyramid> {
    @Override
    public int compare(Pyramid pyramidOne, Pyramid pyramidTwo) {
        Point pointOne = pyramidOne.getFirstPoint();
        Point pointTwo = pyramidTwo.getFirstPoint();
        double xPointOne = pointOne.getX();
        double xPointTwo = pointTwo.getX();
        return Double.compare(xPointOne, xPointTwo);
    }
}
