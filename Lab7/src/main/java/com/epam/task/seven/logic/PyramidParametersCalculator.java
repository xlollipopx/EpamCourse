package com.epam.task.seven.logic;

import com.epam.task.seven.model.Point;
import com.epam.task.seven.model.Pyramid;

public class PyramidParametersCalculator {

    public double calculateSurfaceArea(Pyramid pyramid) {
        Point[] points = pyramid.getPyramidCoordinates();
        double area = calculateEdgeArea(points[0], points[1], points[2])
                +  calculateEdgeArea(points[0], points[2], points[3])
                + calculateEdgeArea(points[0], points[1], points[3])
                + calculateEdgeArea(points[1], points[2], points[2]);
        return area;
    }

    public double calculateVolume(Pyramid pyramid) {
        Point[] points = pyramid.getPyramidCoordinates();
        double[] vectorOne = {points[0].getX() - points[1].getX(),
                points[0].getY() - points[1].getY(),
                points[0].getZ() - points[1].getZ() };
        double[] vectorTwo = {points[0].getX() - points[2].getX(),
                points[0].getY() - points[2].getY(),
                points[0].getZ() - points[2].getZ() };
        double[] vectorThree = {points[0].getX() - points[3].getX(),
                points[0].getY() - points[3].getY(),
                points[0].getZ() - points[3].getZ()};
        double volume = (vectorOne[0] * vectorTwo[1] * vectorThree[2]
                + vectorOne[2] * vectorTwo[0] * vectorThree[1]
                + vectorOne[1] * vectorTwo[2] * vectorThree[0]
                - vectorOne[2] * vectorTwo[1] * vectorThree[0]
                - vectorOne[0] * vectorTwo[2] * vectorThree[1]
                - vectorOne[1] * vectorTwo[0] * vectorThree[2]);
        double multiplier = (double)1/6;
        return Math.abs(volume) * multiplier;
    }

    private double calculateEdgeArea(Point A, Point B, Point C) {
        double[] vectorOne = {A.getX() - B.getX(),
                A.getY() - B.getY(),
                A.getZ() - B.getZ() };
        double[] vectorTwo = {A.getX() - C.getX(),
                A.getY() - C.getY(),
                A.getZ() - C.getZ() };
        double area = Math.pow(vectorOne[0] * vectorTwo[1] - vectorOne[1] * vectorTwo[0], 2)
                + Math.pow(vectorOne[0] * vectorTwo[2] - vectorOne[2] * vectorTwo[0], 2)
                + Math.pow(vectorOne[1] * vectorTwo[2] - vectorOne[2] * vectorTwo[1], 2);
        return Math.pow(area, 0.5);
    }


}
