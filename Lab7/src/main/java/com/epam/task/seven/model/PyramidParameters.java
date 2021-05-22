package com.epam.task.seven.model;

public class PyramidParameters {
    private double volume;
    private double surfaceArea;

    public PyramidParameters(double volume, double surfaceArea) {
        this.volume = volume;
        this.surfaceArea = surfaceArea;
    }

    public double getVolume() {
        return volume;
    }

    public double getSurfaceArea() {
        return surfaceArea;
    }

}
