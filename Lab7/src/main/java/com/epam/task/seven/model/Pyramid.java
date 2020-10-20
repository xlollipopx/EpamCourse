package com.epam.task.seven.model;

import com.epam.task.seven.Main;
import com.epam.task.seven.data.DataException;
import com.epam.task.seven.data.DataReader;
import com.epam.task.seven.logic.PyramidIdGenerator;
import com.epam.task.seven.logic.PyramidIdGeneratorImpl;
import com.epam.task.seven.logic.PyramidParametersCalculator;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import org.apache.log4j.Logger;


public class Pyramid {
    private int id;
    private final static Logger LOGGER = Logger.getLogger(Pyramid.class);
    private static final PyramidIdGenerator pyramidIdGenerator = new PyramidIdGeneratorImpl();
    private List<Point> pyramidCoordinates = new LinkedList<>();

    public Pyramid(Point firstPoint,Point secondPoint,
                   Point thirdPoint, Point fourthPoint) {
        pyramidCoordinates.add(firstPoint);
        pyramidCoordinates.add(secondPoint);
        pyramidCoordinates.add(thirdPoint);
        pyramidCoordinates.add(fourthPoint);
        id = pyramidIdGenerator.generate();

    }

    public Pyramid(List<Point> points) {
       if(points != null && points.size() == 4) {
           id = pyramidIdGenerator.generate();
           pyramidCoordinates.addAll(points);
       }
       else{
           LOGGER.error("Number of points must be four!");
       }
    }

    public int getId() {
        return id;
    }

    public Point[] getPyramidCoordinates() {
        Point[] points = new Point[pyramidCoordinates.size()];
        return pyramidCoordinates.toArray(points);
    }

    public Point getFirstPoint() {
        return pyramidCoordinates.get(0);
    }

    public Point getSecondPoint() {
        return pyramidCoordinates.get(1);
    }

    public Point getThirdPoint() {
        return pyramidCoordinates.get(2);
    }

    public Point getFourthPoint() {
        return pyramidCoordinates.get(3);
    }

    public void setFirstPoint(Point point) {
        pyramidCoordinates.set(0, point);
    }

    public void setSecondPoint(Point point) {
        pyramidCoordinates.set(1, point);
    }

    public void setThirdPoint(Point point) {
        pyramidCoordinates.set(2, point);
    }

    public void setFourthPoint(Point point) {
        pyramidCoordinates.set(3, point);
    }

    public double getVolume() {
        PyramidParametersCalculator pyramidParametersCalculator = new PyramidParametersCalculator();
        return pyramidParametersCalculator.calculateVolume(this);
    }

    public double getSurfaceArea() {
        PyramidParametersCalculator pyramidParametersCalculator = new PyramidParametersCalculator();
        return pyramidParametersCalculator.calculateSurfaceArea(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Pyramid pyramid = (Pyramid) o;
        int amount = 0;
        boolean[] used = new boolean[4];
        for(int i = 0; i < pyramidCoordinates.size(); i++) {
            for(int j = 0; j < pyramidCoordinates.size(); j++) {
                if(pyramidCoordinates.get(i).equals(
                        pyramid.getPyramidCoordinates()[j])
                        && !used[j]){
                    used[j] = true;
                    amount++;
                    break;
                }
            }
        }
        return amount == pyramidCoordinates.size();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        for(int i = 0; i < pyramidCoordinates.size(); i++) {
            result = prime * result + pyramidCoordinates.get(i).hashCode();
        }
        return result;
    }

    @Override
    public String toString() {
        return "Pyramid{" +
                "pyramidCoordinates=" + pyramidCoordinates +
                '}';
    }
}
