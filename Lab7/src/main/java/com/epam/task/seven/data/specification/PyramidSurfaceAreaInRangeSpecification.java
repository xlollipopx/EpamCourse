package com.epam.task.seven.data.specification;

import com.epam.task.seven.model.Pyramid;

public class PyramidSurfaceAreaInRangeSpecification implements Specification<Pyramid>{
    private double minArea;
    private double maxArea;

    public PyramidSurfaceAreaInRangeSpecification(double minArea, double maxArea) {
        this.minArea = minArea;
        this.maxArea = maxArea;
    }

    @Override
    public boolean specified(Pyramid pyramid){
        double pyramidVolume = pyramid.getVolume();
        return (pyramidVolume <= maxArea &&
                pyramidVolume >= minArea);
    }
}
